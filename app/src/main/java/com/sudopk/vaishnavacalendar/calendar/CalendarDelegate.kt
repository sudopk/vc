package com.sudopk.vaishnavacalendar.calendar

import com.sudopk.vaishnavacalendar.VCalendar

interface CalendarDelegate {
    fun onRefresh()

    fun tryShowingCalendar()

    fun onChangeLocationRequest()

    fun onCalendarResponse(body: VCalendar)

    fun onCalendarRequestFailed()
}
