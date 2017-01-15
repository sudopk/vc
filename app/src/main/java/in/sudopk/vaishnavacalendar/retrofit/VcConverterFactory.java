package in.sudopk.vaishnavacalendar.retrofit;

import android.text.TextUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import in.sudopk.vaishnavacalendar.Country;
import in.sudopk.vaishnavacalendar.DayCalendar;
import in.sudopk.vaishnavacalendar.Location;
import in.sudopk.vaishnavacalendar.VCalendar;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class VcConverterFactory extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(final Type type, final Annotation[]
            annotations, final Retrofit retrofit) {
        if (annotations != null) {
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(VcApi.Calendar.class)) {
                    return new VcCalendarResponseConverter();
                } else if (annotation.annotationType().equals(VcApi.Locations.class)) {
                    return new VcLocationResponseConverter();
                }
            }
        }
        return super.responseBodyConverter(type, annotations, retrofit);
    }


    private static class VcCalendarResponseConverter implements Converter<ResponseBody, VCalendar> {

        private List<String> mEventData;
        private int mDate;

        @Override
        public VCalendar convert(final ResponseBody value) throws IOException {
            final Document document = Jsoup.parse(value.string());
            final Elements days = document.select("body center>table:nth-child(3)" +
                    ">tbody>tr>td>table>tbody");
            final List<DayCalendar> calendar = new ArrayList<>();
            for (final Element day : days) {
                final DayCalendar dayCalendar = parseDay(day);
                if (dayCalendar != null) {
                    calendar.add(dayCalendar);
                }
            }
            return new VCalendar(calendar);
        }

        private DayCalendar parseDay(final Element day) {
            // each day is a <table>
            final Elements events = day.select(">tr");
            mDate = 0;
            mEventData = new ArrayList<>(events.size());
            boolean firstRow = true;
            for (final Element event : events) {
                parseDayEvent(event, firstRow);
                firstRow = false;
            }
            if (mDate != 0 && !mEventData.isEmpty()) {
                return new DayCalendar(mDate, mEventData);
            }
            return null;
        }

        private void parseDayEvent(final Element event, final boolean dateEvent) {
            int col = 0;
            final Elements details = event.select(">td");
            for (final Element detail : details) {
                parseEventDetail(detail, dateEvent && (col == 1));
                col++;
            }
        }


        private void parseEventDetail(final Element detail, final boolean dateEvent) {
            String data = detail.text();
            if (dateEvent) {
                mDate = Integer.parseInt(data);
            } else {
                data += parseImgToText(detail.select("img"));
                data = data.trim();
                if (!TextUtils.isEmpty(data)) {
                    mEventData.add(data);
                }
            }
        }

        private String parseImgToText(final Elements imgs) {
            if (imgs.size() > 0) {
                final String src = imgs.attr("src");
                //TODO: Use res strings
                if ("amavasya.gif".equals(src)) {
                    return "[New moon]";
                } else if ("purnima.gif".equals(src)) {
                    return "[Full moon]";
                } else if ("ap.gif".equals(src)) {
                    return " [Appearance]";
                } else if ("dis.gif".equals(src)) {
                    return " [Disapperance]";
                }
            }
            return "";
        }
    }

    private static class VcLocationResponseConverter implements Converter<ResponseBody,
            List<Country>> {
        private static final String PREFIX_OF_LOCATIONS_WITH_ID = "....";
        private List<Country> mLocationData;

        private static boolean isCountryName(final String locationName) {
            return !locationName.startsWith(PREFIX_OF_LOCATIONS_WITH_ID);
        }

        @Override
        public List<Country> convert(final ResponseBody value) throws IOException {
            final Document document = Jsoup.parse(value.string());
            final Elements locationGroups = document.select("select[id=CIID]");
            mLocationData = new ArrayList<>();
            for (final Element locationGroup : locationGroups) {
                parseLocationGroup(locationGroup);
            }

            return mLocationData;
        }

        private void parseLocationGroup(final Element locationGroup) {
            final Elements locations = locationGroup.select(">option");
            // initializing it to avoid null check, but it should be overridden in the loop
            List<Location> locationsWithId = new ArrayList<>();
            String country = "";
            for (final Element location : locations) {
                final String locationName = location.text();
                if (isCountryName(locationName)) {
                    // add data of last country
                    addCountryData(country, locationsWithId);

                    country = locationName;
                    locationsWithId = new ArrayList<>();
                } else {
                    // strip the prefix from locationName
                    locationsWithId.add(
                            new Location(
                                    locationName.substring(PREFIX_OF_LOCATIONS_WITH_ID.length()),
                                    location.attr("value")));
                }
            }
            addCountryData(country, locationsWithId);
        }

        private void addCountryData(final String country,
                                    final List<Location> locations) {
            if (!locations.isEmpty() && !TextUtils.isEmpty(country)) {
                Collections.sort(locations);
                mLocationData.add(new Country(country, locations));
            }
        }
    }
}
