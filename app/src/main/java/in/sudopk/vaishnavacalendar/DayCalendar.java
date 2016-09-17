package in.sudopk.vaishnavacalendar;

import android.support.annotation.NonNull;

import java.util.List;

public class DayCalendar implements Comparable<DayCalendar> {
    private static final String DELIMITER = "\n";
    private final int mDate;
    private final String mEvents;

    public DayCalendar(final int date, final List<String> events) {
        mDate = date;
        final StringBuilder stringBuilder = new StringBuilder();
        for (String event : events) {
            stringBuilder.append(event);
            stringBuilder.append(DELIMITER);
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - DELIMITER.length());
        }
        mEvents = stringBuilder.toString();
    }

    public int getDate() {
        return mDate;
    }

    public String getEvents() {
        return mEvents;
    }

    @Override
    public int compareTo(@NonNull final DayCalendar dayCalendar) {
        return getDate() - dayCalendar.getDate();
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof DayCalendar &&
                compareTo((DayCalendar) obj) == 0;
    }
}
