package com.sudopk.vc.retrofit

import com.google.common.truth.Truth.assertThat
import com.sudopk.vc.calendar.DayCalendar
import org.junit.Test

// print("DayCalendar(date=${c.date}, events=listOf(\"${c.events.joinToString("\",\"")}\")),")
private val EXPECTED_DAYS = listOf(
  DayCalendar(
    date = 1,
    events = listOf(
      "Dvadasi",
      "Break fast 07:05 - 10:07",
      "(Daylight saving not considered)",
      "Sri Kaliya Krsnadasa [Disappearance]"
    )
  ),
  DayCalendar(date = 2, events = listOf("Caturdasi", "HH Radhanath Svami [Appearance]")),
  DayCalendar(date = 3, events = listOf("Amavasya")),
  DayCalendar(date = 4, events = listOf("Pratipat", "HH Partha Sarathi Gosvami [Appearance]")),
  DayCalendar(date = 5, events = listOf("Dvitiya")),
  DayCalendar(date = 6, events = listOf("Tritiya")),
  DayCalendar(date = 7, events = listOf("Caturthi")),
  DayCalendar(date = 8, events = listOf("Pancami")),
  DayCalendar(date = 9, events = listOf("Saptami")),
  DayCalendar(date = 10, events = listOf("Astami")),
  DayCalendar(date = 11, events = listOf("Navami")),
  DayCalendar(
    date = 12,
    events = listOf(
      "Dasami",
      "Advent of Srimad Bhagavad-gita",
      "HH Krishna Ksetra Svami [Appearance]"
    )
  ),
  DayCalendar(date = 13, events = listOf("Dasami")),
  DayCalendar(
    date = 14,
    events = listOf(
      "Suddha Ekadasi",
      "Moksada Ekadasi",
      "Advent of Srimad Bhagavad-",
      "HH Satsvarupa dasa Gosvami [Appearance]"
    )
  ),
  DayCalendar(
    date = 15,
    events = listOf("Dvadasi", "Break fast 07:16 - 10:28", "(Daylight saving not considered)")
  ),
  DayCalendar(date = 16, events = listOf("Trayodasi")),
  DayCalendar(date = 17, events = listOf("Caturdasi")),
  DayCalendar(
    date = 18,
    events = listOf("Purnima", "Katyayani vrata ends", "HH Mahavisnu Gosvami [Appearance]")
  ),
  DayCalendar(date = 19, events = listOf("Pratipat", "Narayana Masa")),
  DayCalendar(date = 20, events = listOf("Dvitiya")),
  DayCalendar(date = 21, events = listOf("Tritiya")),
  DayCalendar(
    date = 22,
    events = listOf(
      "Caturthi",
      "Srila Bhaktisiddhanta Sarasvati Thakura [Disappearance]",
      "(Fasting till noon)"
    )
  ),
  DayCalendar(date = 23, events = listOf("Pancami")),
  DayCalendar(date = 24, events = listOf("Sasti")),
  DayCalendar(date = 25, events = listOf("Saptami")),
  DayCalendar(date = 26, events = listOf("Astami")),
  DayCalendar(date = 27, events = listOf("Navami", "HH Niranjana Svami [Appearance]")),
  DayCalendar(date = 28, events = listOf("Dasami")),
  DayCalendar(
    date = 29,
    events = listOf("Suddha Ekadasi", "Saphala Ekadasi", "Sri Devananda Pandita [Disappearance]")
  ),
  DayCalendar(date = 30, events = listOf()),
  DayCalendar(date = 31, events = listOf())
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
