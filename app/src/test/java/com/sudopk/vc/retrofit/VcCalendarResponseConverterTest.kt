package com.sudopk.vc.retrofit

import com.google.common.truth.Truth.assertThat
import com.sudopk.vc.calendar.DayCalendar
import org.junit.Test

// print("DayCalendar(date=${c.date}, events=listOf(\"${c.events.joinToString("\",\"")}\")),")
private val EXPECTED_DAYS = listOf(
  DayCalendar(date = 1, events = listOf("Purnima")),
  DayCalendar(date = 2, events = listOf("Pratipat")),
  DayCalendar(date = 3, events = listOf("Dvitiya")),
  DayCalendar(date = 4, events = listOf("Tritiya")),
  DayCalendar(date = 5, events = listOf("Caturthi")),
  DayCalendar(date = 6, events = listOf("Pancami")),
  DayCalendar(date = 7, events = listOf("Sasti")),
  DayCalendar(date = 8, events = listOf("Sasti")),
  DayCalendar(date = 9, events = listOf("Saptami")),
  DayCalendar(date = 10, events = listOf("Astami")),
  DayCalendar(date = 11, events = listOf("Navami")),
  DayCalendar(date = 12, events = listOf("Dasami")),
  DayCalendar(date = 13, events = listOf("Suddha Ekadasi", "Parama Ekadasi")),
  DayCalendar(
    date = 14,
    events = listOf("Trayodasi", "Break fast 06:24 - 10:45 (Daylight saving not considered)")
  ),
  DayCalendar(date = 15, events = listOf("Caturdasi")),
  DayCalendar(date = 16, events = listOf("Amavasya", "Padmanabha Masa continued")),
  DayCalendar(date = 17, events = listOf("Pratipat", "Tula Sankranti - [Libra]")),
  DayCalendar(date = 18, events = listOf("Dvitiya")),
  DayCalendar(date = 19, events = listOf("Caturthi")),
  DayCalendar(date = 20, events = listOf("Pancami")),
  DayCalendar(date = 21, events = listOf("Sasti")),
  DayCalendar(date = 22, events = listOf("Saptami", "Durga Puja")),
  DayCalendar(date = 23, events = listOf("Astami")),
  DayCalendar(date = 24, events = listOf("Navami")),
  DayCalendar(
    date = 25,
    events = listOf(
      "Dasami",
      "Ramacandra Vijayotsava",
      "Sri Madhvacarya [Appearance]",
      "HH Bhaktisvarupa Damodar Svami [Appearance]"
    )
  ),
  DayCalendar(
    date = 26,
    events = listOf(
      "Suddha Ekadasi",
      "Pasankusa Ekadasi",
      "HH Bir Krishna dasa Gosvami [Appearance]"
    )
  ),
  DayCalendar(
    date = 27,
    events = listOf(
      "Dvadasi",
      "Break fast 08:51 - 10:38 (Daylight saving not considered)",
      "Srila Raghunatha Dasa Gosvami [Disappearance]",
      "Srila Raghunatha Bhatta Gosvami [Disappearance]",
      "Srila Krsnadasa Kaviraja Gosvami [Disappearance]"
    )
  ),
  DayCalendar(date = 28, events = listOf("Trayodasi")),
  DayCalendar(date = 29, events = listOf("Trayodasi")),
  DayCalendar(date = 30, events = listOf("Caturdasi")),
  DayCalendar(
    date = 31,
    events = listOf(
      "Purnima",
      "Sri Krsna Saradiya Rasayatra",
      "Sri Murari Gupta [Disappearance]",
      "Laksmi Puja",
      "Fourth month of Caturmasya begins",
      "(Fast from urad dahl for one month.)",
      "Damodara Masa"
    )
  ),
)

class VcCalendarResponseConverterTest {
  @Test
  fun convert() {
    val vCalendar = CalendarParser.convert(VC_HTML)

    assertThat(vCalendar.size).isEqualTo(31)

    // All days are unique
    assertThat(vCalendar.toSet().size).isEqualTo(vCalendar.size)

    vCalendar.forEachIndexed { index, day ->
      assertThat(day.date).isEqualTo(index + 1)
    }

    assertThat(vCalendar).isEqualTo(EXPECTED_DAYS)
  }
}
