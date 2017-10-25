package com.sudopk.vaishnavacalendar

import com.sudopk.vaishnavacalendar.calendar.CalendarDelegate

object NoActionCalendar : CalendarDelegate {
    override fun onRefresh() {

    }

    override fun tryShowingCalendar() {

    }

    override fun onChangeLocationRequest() {

    }

    override fun onCalendarResponse(body: VCalendar) {

    }

    override fun onCalendarRequestFailed() {

    }
}
