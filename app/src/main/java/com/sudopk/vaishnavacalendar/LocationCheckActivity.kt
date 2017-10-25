package com.sudopk.vaishnavacalendar

import com.sudopk.vaishnavacalendar.calendar.CalendarPagerFragment
import com.sudopk.vaishnavacalendar.calendar.CalendarStore
import com.sudopk.vaishnavacalendar.core.hasFragmentByTag
import com.sudopk.vaishnavacalendar.core.isNull
import com.sudopk.vaishnavacalendar.core.replace
import com.sudopk.vaishnavacalendar.core.vcApp
import com.sudopk.vaishnavacalendar.location.LocationStore
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
        supportFragmentManager.replace(R.id.container, CalendarPagerFragment())
    }

    private fun launchLocationFragment() {

    }
}

