package com.sudopk.vc.calendar

interface CalendarDelegate {
    fun onRefresh()

    fun tryShowingCalendar()

    fun onChangeLocationRequest()

    fun onCalendarResponse(body: VCalendar)

    fun onCalendarRequestFailed()
}
