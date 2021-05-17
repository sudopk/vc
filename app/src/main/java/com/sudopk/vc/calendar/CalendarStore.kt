package com.sudopk.vc.calendar

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.sudopk.vc.core.CalUtil
import com.sudopk.vc.location.Location
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton


val MONTHS_TO_STORE = 5
private val CALENDAR_KEY_FORMAT = "calendar_%d_%d"
private val LOCATION_KEY = "location"

@Singleton
class CalendarStore @Inject constructor(
  @ApplicationContext context: Context,
  private val mGson: Gson
) {
  private val mPreferences: SharedPreferences =
    PreferenceManager.getDefaultSharedPreferences(context)

  init {
    cleanupExtra()
  }

  /**
   * @param month 1 to 12
   * @param year  Full year e.g. 2016
   */
  fun getCalendar(month: Int, year: Int): VCalendar {
    val calendarString = mPreferences.getString(CALENDAR_KEY_FORMAT.format(month, year), "")
    return if (calendarString!!.isBlank()) {
      emptyList()
    } else {
      mGson.fromJson(calendarString, VCalendarTypeToken)
    }
  }

  /**
   * @param month 1 to 12
   * *
   * @param year  full year e.g. 2016
   */
  fun saveCalendar(month: Int, year: Int, calendar: VCalendar) {
    mPreferences.edit {
      putString(CALENDAR_KEY_FORMAT.format(month, year), mGson.toJson(calendar))
    }
  }

  fun saveCalendar(monthYear: MonthYear, calendar: VCalendar) {
    saveCalendar(monthYear.month, monthYear.year, calendar)
  }

  /**
   * @param month 1 to 12
   * @param year  Full year e.g. 2016
   */
  fun hasCalendar(month: Int, year: Int): Boolean {
    return mPreferences.getString(CALENDAR_KEY_FORMAT.format(month, year), "")!!.isNotBlank()
  }

  fun hasCalendar(monthYear: MonthYear): Boolean {
    return hasCalendar(monthYear.month, monthYear.year)
  }

  fun removeCalendar(monthYear: MonthYear) {
    removeCalendar(monthYear.month, monthYear.year)
  }

  fun getCalendar(monthYear: MonthYear): VCalendar {
    return getCalendar(monthYear.month, monthYear.year)
  }

  /**
   * @param month 1 to 12
   * @param year  Full year e.g. 2016
   */
  fun removeCalendar(month: Int, year: Int) {
    mPreferences.edit {
      remove(CALENDAR_KEY_FORMAT.format(month, year))
    }
  }

  fun cleanupExtra() {
    for (i in 1..5) {
      val offset = MONTHS_TO_STORE / 2 + i
      var calendar = CalUtil.getCalendar(offset)
      removeCalendar(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR))
      calendar = CalUtil.getCalendar(-offset)
      removeCalendar(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR))
    }
  }

  fun cleanupAll() {
    cleanupExtra()
    for (i in -MONTHS_TO_STORE..MONTHS_TO_STORE) {
      val calendar = CalUtil.getCalendar(i)
      removeCalendar(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR))
    }
  }

  var location: Location?
    get() = mGson.fromJson(mPreferences.getString(LOCATION_KEY, null), Location::class.java)
    set(location) {
      cleanupAll()
      mPreferences.edit { putString(LOCATION_KEY, mGson.toJson(location)) }
    }
}
