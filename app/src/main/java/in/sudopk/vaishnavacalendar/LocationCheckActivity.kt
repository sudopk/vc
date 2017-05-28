package `in`.sudopk.vaishnavacalendar

import `in`.sudopk.coreandroid.Fm
import `in`.sudopk.vaishnavacalendar.calendar.CalendarPagerFragment
import `in`.sudopk.vaishnavacalendar.calendar.CalendarStore
import `in`.sudopk.vaishnavacalendar.core.hasFragmentByTag
import `in`.sudopk.vaishnavacalendar.core.isNull
import `in`.sudopk.vaishnavacalendar.location.LocationStore
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

const val CONTAINTED_FRAGMENT = "ContainedFragment";

class LocationCheckActivity : AppCompatActivity() {
    private lateinit var mLocationStore: LocationStore
    private lateinit var mCalendarStore: CalendarStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.container)

        mCalendarStore = vcApp.calendarStore
        mLocationStore = vcApp.locationStore

        if (!hasFragmentByTag(CONTAINTED_FRAGMENT)) {
            launchLocationOrCalendarFragment()
        }
    }

    private fun launchLocationOrCalendarFragment() {
        if(mCalendarStore.location.isNull()) {
            launchLocationFragment()
        } else {
            launchCalendarFragment()
        }
    }

    private fun launchCalendarFragment() {
        Fm.replace(supportFragmentManager, R.id.container, CalendarPagerFragment())
    }

    private fun launchLocationFragment() {

    }
}

