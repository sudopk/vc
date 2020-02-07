package com.sudopk.vc.core

import java.text.SimpleDateFormat
import java.util.*

object CalUtil {
  fun getCalendar(monthOffset: Int): Calendar {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.MONTH, monthOffset)
    return calendar
  }
}

fun Calendar.monthAbbreviation(): String {
  return SimpleDateFormat("MMM", Locale.getDefault()).format(time)
}

fun Calendar.weekDayAbbreviation(): String {
  return SimpleDateFormat("EE", Locale.getDefault()).format(time)
}