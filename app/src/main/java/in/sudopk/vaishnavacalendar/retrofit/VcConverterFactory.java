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
    public Converter<ResponseBody, ?> responseBodyConverter(final Type type, final Annotation[] annotations, final Retrofit retrofit) {
        if (annotations != null) {
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(VcApi.Calendar.class)) {
                    return new VcCalendarResponseConverter();
                } else if (annotation.annotationType().equals(VcApi.Locations.class)) {
                    return new VcLocationResponseConverter();
                }
            }
        }
        return null;
    }


    private class VcCalendarResponseConverter implements Converter<ResponseBody, VCalendar> {
        @Override
        public VCalendar convert(final ResponseBody value) throws IOException {
            final Document document = Jsoup.parse(value.string());
            final Elements days = document.select("body center>table:nth-child(3)>tbody>tr>td>table>tbody");
            final List<DayCalendar> calendar = new ArrayList<>();
            for (final Element day : days) {
                // each day is a <table>
                final Elements events = day.select(">tr");
                int date = 0;
                final List<String> eventData = new ArrayList<>(events.size());
                boolean firstRow = true;
                for (final Element event : events) {
                    int col = 0;
                    final Elements details = event.select(">td");
                    for (final Element detail : details) {
                        String data = detail.text();
                        if (firstRow && col == 1) {
                            date = Integer.parseInt(data);
                        } else {
                            final Elements imgs = detail.select("img");
                            if (imgs.size() > 0) {
                                final String src = imgs.attr("src");
                                //TODO: Use res strings
                                if ("amavasya.gif".equals(src)) {
                                    data = "[New moon]";
                                } else if ("purnima.gif".equals(src)) {
                                    data = "[Full moon]";
                                } else if ("ap.gif".equals(src)) {
                                    data += " [Appearance]";
                                } else if ("dis.gif".equals(src)) {
                                    data += " [Disapperance]";
                                }
                            }
                            if (!TextUtils.isEmpty(data)) {
                                eventData.add(data);
                            }
                        }
                        col++;
                    }
                    firstRow = false;
                }
                if (date != 0) {
                    calendar.add(new DayCalendar(date, eventData));
                }
            }
            return new VCalendar(calendar);
        }
    }

    private class VcLocationResponseConverter implements Converter<ResponseBody, List<Country>> {
        private static final String PREFIX_OF_LOCATIONS_WITH_ID = "....";

        @Override
        public List<Country> convert(final ResponseBody value) throws IOException {
            final Document document = Jsoup.parse(value.string());
            final Elements locationGroups = document.select("select[id=CIID]");
            List<Country> locationData = new ArrayList<>();
            for (final Element locationGroup : locationGroups) {
                final Elements locations = locationGroup.select(">option");
                // initializing it to avoid null check, but it should be overridden in the loop
                List<Location> locationsWithId = new ArrayList<>();
                String country = "";
                for (final Element location : locations) {
                    final String locationName = location.text();
                    if (locationName.startsWith(PREFIX_OF_LOCATIONS_WITH_ID)) {
                        // strip the prefix from locationName
                        locationsWithId.add(
                                new Location(
                                        locationName.substring(PREFIX_OF_LOCATIONS_WITH_ID.length()),
                                        location.attr("value")));
                    } else {
                        // add data of last country
                        addCountryData(locationData, country, locationsWithId);

                        country = locationName;
                        locationsWithId = new ArrayList<>();
                    }
                }
                addCountryData(locationData, country, locationsWithId);
            }

            return locationData;
        }

        private void addCountryData(final List<Country> locationData,
                                    final String country,
                                    final List<Location> locations) {
            if (!locations.isEmpty() && !TextUtils.isEmpty(country)) {
                Collections.sort(locations);
                locationData.add(new Country(country, locations));
            }
        }
    }
}
