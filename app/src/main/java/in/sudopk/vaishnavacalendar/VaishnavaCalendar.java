package in.sudopk.vaishnavacalendar;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class VaishnavaCalendar {
    private static final String TAG = "VaishnavaCalendar";
    private static final String DAY_XPATH = "/html/body//table";

    public static void parse(final String html) {
        Document doc = Jsoup.parse(html);

        Elements tables = doc.select("body > table");
        Element calendarTable = tables.get(2);

        Log.d(TAG, "parse: ");

    }
}
