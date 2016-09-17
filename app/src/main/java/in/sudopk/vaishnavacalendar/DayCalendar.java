package in.sudopk.vaishnavacalendar;

import android.support.annotation.NonNull;

import java.util.List;

public class DayCalendar implements Comparable<DayCalendar> {
    private final int mDate;
    private final List<String> mEvents;

    public DayCalendar(final int date, final List<String> events) {
        mDate = date;
        mEvents = events;
    }

    public int getDate() {
        return mDate;
    }

    public List<String> getEvents() {
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
