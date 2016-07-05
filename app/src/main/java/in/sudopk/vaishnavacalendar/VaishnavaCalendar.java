package in.sudopk.vaishnavacalendar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class VaishnavaCalendar {
    private static final String TAG = "VaishnavaCalendar";
    private static final String DAY_XPATH = "/html/body//table";

    public static List<DayCalendar> parseHtml(final String html) {
        String str = html.toLowerCase();

        /*int index = str.indexOf("table");
        int lastIndex = str.lastIndexOf("table");
        str = "<html><body>" + str.substring(index-1, lastIndex+6) + "</body></html>";
        Pattern p = Pattern.compile("<object.*?</object>");
        Matcher m = p.matcher(str);
        if (m.find()) {
            str = m.replaceAll("");
        }
        p = Pattern.compile("<(.*?)(>|( .*?>))");*/
        String pattern = "<tr.*?>.*?<td.*?>([a-z]+)</td>.*?<td.*?>([0-9]+)</td>.*?</tr>";
        Pattern p = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher m = p.matcher(str);
        while (m.find()) {
            Log.d(TAG, m.group(1) + " ======= " + m.group(0));
        }
        return null;
    }

    @Nullable
    public static List<DayCalendar> getDayCalendars(final String str) {
        Document doc = null;
        try {
            //final InputStreamReader reader = new InputStreamReader(context.getAssets().open("calendar.html"));

            doc = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().parse(new InputSource(new StringReader(str)));
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }

        XPathExpression xpath = null;
        try {
            xpath = XPathFactory.newInstance()
                    .newXPath().compile(DAY_XPATH);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        if (doc != null && xpath != null) {
            try {
                String result = (String) xpath.evaluate(doc, XPathConstants.STRING);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void jsoup(final String html) {
        //Document doc = Jsoup.parse(html);

//http://jsoup.org/cookbook/input/load-document-from-url
//Document doc = Jsoup.connect("http://example.com/").get();

        /*Element content = doc.getElementById("content");
        Elements links = content.getElementsByTag("a");
        for (Element link : links) {
            String linkHref = link.attr("href");
            String linkText = link.text();
        }*/
    }
}
