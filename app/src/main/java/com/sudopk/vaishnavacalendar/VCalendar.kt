package com.sudopk.vaishnavacalendar

import com.google.gson.reflect.TypeToken
import com.sudopk.vaishnavacalendar.calendar.DayCalendar
import java.io.Serializable
import java.lang.reflect.Type

typealias VCalendar = List<DayCalendar>

val VCalendarTypeToken: Type = object : TypeToken<VCalendar>() {}.type

data class MonthYear(val month: Int, val year: Int) : Serializable
