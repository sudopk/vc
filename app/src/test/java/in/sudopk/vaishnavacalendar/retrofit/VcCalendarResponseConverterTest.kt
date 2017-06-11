package `in`.sudopk.vaishnavacalendar.retrofit

import org.junit.Test

import java.util.HashSet

import `in`.sudopk.vaishnavacalendar.calendar.DayCalendar
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse


class VcCalendarResponseConverterTest {
    @Test
    fun convert() {
        val converter = VcCalendarResponseConverter(MockStrFromRes())

        val vCalendar = converter.convert(VC_HTML)

        assertEquals(DAYS_IN_VC_HTML, vCalendar.size)

        val uniqueDays = HashSet<DayCalendar>(vCalendar.size)
        for (day in vCalendar) {
            assertFalse(uniqueDays.contains(day))
            uniqueDays.add(day)
        }
        assertEquals(DAYS_IN_VC_HTML, uniqueDays.size)
    }
}
