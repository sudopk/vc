package com.sudopk.vaishnavacalendar

import com.sudopk.vaishnavacalendar.calendar.DayCalendar
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

typealias VCalendar = List<DayCalendar>

val VCalendarTypeToken : Type = object : TypeToken<VCalendar>() {}.type
