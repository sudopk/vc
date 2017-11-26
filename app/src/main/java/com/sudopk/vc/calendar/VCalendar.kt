package com.sudopk.vc.calendar

import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type

typealias VCalendar = List<DayCalendar>

val VCalendarTypeToken: Type = object : TypeToken<VCalendar>() {}.type

data class MonthYear(val month: Int, val year: Int) : Serializable
