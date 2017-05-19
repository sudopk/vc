package `in`.sudopk.vaishnavacalendar

import `in`.sudopk.vaishnavacalendar.calendar.DayCalendar

class VCalendar(val calendar: List<DayCalendar>) {

    fun hasData(): Boolean {
        return !calendar.isEmpty()
    }
}
