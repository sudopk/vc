package in.sudopk.vaishnavacalendar.calendar;

import in.sudopk.vaishnavacalendar.VCalendar;

public interface CalendarDelegate {
    void onRefresh();

    void tryShowingCalendar();

    void onChangeLocationRequest();

    void onCalendarResponse(VCalendar body);

    void onCalendarRequestFailed();
}
