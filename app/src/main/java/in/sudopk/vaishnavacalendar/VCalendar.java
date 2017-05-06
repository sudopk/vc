package in.sudopk.vaishnavacalendar;

import java.util.List;

import in.sudopk.vaishnavacalendar.calendar.DayCalendar;

public class VCalendar {
    private List<DayCalendar> mCalendar;

    public VCalendar(final List<DayCalendar> calendar) {
        mCalendar = calendar;
    }

    public List<DayCalendar> getCalendar() {
        return mCalendar;
    }

    public boolean hasData() {
        return mCalendar != null && !mCalendar.isEmpty();
    }
}
