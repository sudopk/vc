package in.sudopk.vaishnavacalendar;

import java.util.Calendar;

public class CalendarUtil {
    public static Calendar getCalendar(int monthOffset) {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, monthOffset);
        return calendar;
    }
}
