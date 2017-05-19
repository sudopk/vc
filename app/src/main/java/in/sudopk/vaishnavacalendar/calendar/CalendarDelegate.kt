package `in`.sudopk.vaishnavacalendar.calendar

import `in`.sudopk.vaishnavacalendar.VCalendar

interface CalendarDelegate {
    fun onRefresh()

    fun tryShowingCalendar()

    fun onChangeLocationRequest()

    fun onCalendarResponse(body: VCalendar)

    fun onCalendarRequestFailed()
}
