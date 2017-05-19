package in.sudopk.vaishnavacalendar.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.Calendar;

import in.sudopk.vaishnavacalendar.location.Location;
import in.sudopk.vaishnavacalendar.VCalendar;
import in.sudopk.vaishnavacalendar.core.CalendarUtil;

@SuppressLint("DefaultLocale")  // not end user string
public class CalendarStore {
    public static final int MONTHS_TO_STORE = 5;
    private static final String CALENDAR_KEY_FORMAT = "calendar_%d_%d";
    private static final String LOCATION_KEY = "location";
    private final SharedPreferences mPreferences;
    private final Gson mGson;

    public CalendarStore(final Context context, final Gson gson) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mGson = gson;
        cleanupExtra();
    }

    /**
     * @param month 1 to 12
     * @param year  full year e.g. 2016
     */
    public VCalendar getCalendar(int month, int year) {
        final String calendarString = mPreferences.getString(String.format(CALENDAR_KEY_FORMAT,
                month, year), "");
        if (calendarString.isEmpty()) {
            return null;
        } else {
            return mGson.fromJson(calendarString, VCalendar.class);
        }
    }

    /**
     * @param month 1 to 12
     * @param year  full year e.g. 2016
     */
    public void saveCalendar(int month, int year, VCalendar calendar) {
        mPreferences.edit()
                .putString(String.format(CALENDAR_KEY_FORMAT, month, year), mGson.toJson(calendar))
                .apply();
    }


    /**
     * @param month 1 to 12
     * @param year  full year e.g. 2016
     */
    public boolean hasCalendar(int month, int year) {
        return !mPreferences.getString(String.format(CALENDAR_KEY_FORMAT, month, year), "")
                .isEmpty();
    }

    /**
     * @param month 1 to 12
     * @param year  full year e.g. 2016
     */
    public void removeCalendar(int month, int year) {
        mPreferences.edit()
                .remove(String.format(CALENDAR_KEY_FORMAT, month, year))
                .apply();
    }

    public void cleanupExtra() {
        for (int i = 1; i <= 5; i++) {
            final int offset = (MONTHS_TO_STORE / 2) + i;
            Calendar calendar = CalendarUtil.INSTANCE.getCalendar(offset);
            removeCalendar(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
            calendar = CalendarUtil.INSTANCE.getCalendar(-offset);
            removeCalendar(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
        }
    }

    public void cleanupAll() {
        cleanupExtra();
        for (int i = -MONTHS_TO_STORE; i <= MONTHS_TO_STORE; i++) {
            Calendar calendar = CalendarUtil.INSTANCE.getCalendar(i);
            removeCalendar(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
        }
    }

    public Location getLocation() {
        return mGson.fromJson(mPreferences.getString(LOCATION_KEY, null), Location.class);
    }

    public void setLocation(Location location) {
        cleanupAll();
        mPreferences.edit()
                .putString(LOCATION_KEY, mGson.toJson(location))
                .apply();
    }
}
