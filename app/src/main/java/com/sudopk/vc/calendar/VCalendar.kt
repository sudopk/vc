package com.sudopk.vc.calendar

import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type
import java.util.Calendar

typealias VCalendar = List<DayCalendar>

val VCalendarTypeToken: Type = object : TypeToken<VCalendar>() {}.type

/**
 * @param month 1 to 12
 * @param year  Full year e.g. 2016
 */
data class MonthYear(val month: Int, val year: Int) : Serializable {
  val title = "$month / $year"
}

fun Calendar.monthYear() = MonthYear(get(Calendar.MONTH) + 1, get(Calendar.YEAR))
