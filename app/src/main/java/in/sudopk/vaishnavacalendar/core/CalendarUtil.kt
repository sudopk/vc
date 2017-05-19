package `in`.sudopk.vaishnavacalendar.core

import java.util.Calendar

object CalendarUtil {
    fun getCalendar(monthOffset: Int): Calendar {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, monthOffset)
        return calendar
    }
}
