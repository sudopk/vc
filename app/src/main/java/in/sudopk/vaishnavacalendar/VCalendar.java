package in.sudopk.vaishnavacalendar;

import java.util.List;

public class VCalendar {
    private List<DayCalendar> mCalendar;

    public VCalendar(final List<DayCalendar> calendar) {
        mCalendar = calendar;
    }

    public List<DayCalendar> getCalendar() {
        return mCalendar;
    }
}
