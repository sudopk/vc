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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class VcConverterFactory extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(final Type type, final Annotation[] annotations, final Retrofit retrofit) {
        return new VcResponseConverter();
    }


    private class VcResponseConverter implements Converter<ResponseBody, VCalendar.Response> {
        @Override
        public VCalendar.Response convert(final ResponseBody value) throws IOException {
            final Document document = Jsoup.parse(value.string());
            final Elements days = document.select("body center>table:nth-child(3)>tbody>tr>td>table>tbody");
            final Map<Integer, List<String>> calendar = new HashMap<>();
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
                    calendar.put(date, eventData);
                }
            }
            return new VCalendar.Response(calendar);
        }
    }
}
