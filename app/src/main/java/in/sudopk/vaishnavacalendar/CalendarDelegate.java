package in.sudopk.vaishnavacalendar;

public interface CalendarDelegate {
    void onRefresh();
    void tryShowingCalendar();

    void onChangeLocationRequest();

    void onCalendarResponse(VCalendar body);

    void onCalendarRequestFailed();
}
