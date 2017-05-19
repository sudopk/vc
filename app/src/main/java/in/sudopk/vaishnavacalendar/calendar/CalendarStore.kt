package `in`.sudopk.vaishnavacalendar.calendar

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

import com.google.gson.Gson

import java.util.Calendar

import `in`.sudopk.vaishnavacalendar.location.Location
import `in`.sudopk.vaishnavacalendar.VCalendar
import `in`.sudopk.vaishnavacalendar.core.CalendarUtil

@SuppressLint("DefaultLocale") // not end user string
class CalendarStore(context: Context, private val mGson: Gson) {
    private val mPreferences: SharedPreferences

    init {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        cleanupExtra()
    }

    /**
     * @param month 1 to 12
     * *
     * @param year  full year e.g. 2016
     */
    fun getCalendar(month: Int, year: Int): VCalendar? {
        val calendarString = mPreferences.getString(String.format(CALENDAR_KEY_FORMAT,
                month, year), "")
        if (calendarString!!.isEmpty()) {
            return null
        } else {
            return mGson.fromJson(calendarString, VCalendar::class.java)
        }
    }

    /**
     * @param month 1 to 12
     * *
     * @param year  full year e.g. 2016
     */
    fun saveCalendar(month: Int, year: Int, calendar: VCalendar) {
        mPreferences.edit()
                .putString(String.format(CALENDAR_KEY_FORMAT, month, year), mGson.toJson(calendar))
                .apply()
    }


    /**
     * @param month 1 to 12
     * *
     * @param year  full year e.g. 2016
     */
    fun hasCalendar(month: Int, year: Int): Boolean {
        return !mPreferences.getString(String.format(CALENDAR_KEY_FORMAT, month, year), "")!!
                .isEmpty()
    }

    /**
     * @param month 1 to 12
     * *
     * @param year  full year e.g. 2016
     */
    fun removeCalendar(month: Int, year: Int) {
        mPreferences.edit()
                .remove(String.format(CALENDAR_KEY_FORMAT, month, year))
                .apply()
    }

    fun cleanupExtra() {
        for (i in 1..5) {
            val offset = MONTHS_TO_STORE / 2 + i
            var calendar = CalendarUtil.getCalendar(offset)
            removeCalendar(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR))
            calendar = CalendarUtil.getCalendar(-offset)
            removeCalendar(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR))
        }
    }

    fun cleanupAll() {
        cleanupExtra()
        for (i in -MONTHS_TO_STORE..MONTHS_TO_STORE) {
            val calendar = CalendarUtil.getCalendar(i)
            removeCalendar(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR))
        }
    }

    var location: Location
        get() = mGson.fromJson(mPreferences.getString(LOCATION_KEY, null), Location::class.java)
        set(location) {
            cleanupAll()
            mPreferences.edit()
                    .putString(LOCATION_KEY, mGson.toJson(location))
                    .apply()
        }

    companion object {
        val MONTHS_TO_STORE = 5
        private val CALENDAR_KEY_FORMAT = "calendar_%d_%d"
        private val LOCATION_KEY = "location"
    }
}
