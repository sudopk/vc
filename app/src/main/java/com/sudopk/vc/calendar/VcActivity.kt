package com.sudopk.vc.calendar

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.sudopk.kandroid.isNull
import com.sudopk.kandroid.notFoundById
import com.sudopk.kandroid.notFoundByTag
import com.sudopk.kandroid.replace
import com.sudopk.vc.R
import com.sudopk.vc.components.ProgressFragment
import com.sudopk.vc.components.ToolbarFragment
import com.sudopk.vc.core.resumed
import com.sudopk.vc.core.vcApp
import com.sudopk.vc.location.Location
import com.sudopk.vc.location.LocationContainer
import com.sudopk.vc.location.LocationFragment

class VcActivity : AppCompatActivity(),
        CalendarPagerFragment.Container,
        LocationContainer {
    private lateinit var mCalendarStore: CalendarStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.container)

        mCalendarStore = vcApp.calendarStore

        val location = mCalendarStore.location
        if (location == null) {
            onChangeLocationRequest()
        } else {
            launchCalendarPagerFragment()
        }
    }

    private fun launchCalendarPagerFragment() {
        supportFragmentManager.notFoundById(R.id.container, CalendarPagerFragment::class) {
            supportFragmentManager.replace(it, CalendarPagerFragment())
        }
    }

    override fun onChangeLocationRequest() {
        supportFragmentManager.notFoundByTag(LocationFragment.TAG) {
            val fragment = LocationFragment.newInstance()
            fragment.show(supportFragmentManager, LocationFragment.TAG)
        }
    }

    override fun onLocationSelected(location: Location) {
        mCalendarStore.location = location
        supportFragmentManager.replace(R.id.container, ProgressFragment())
        launchCalendarPagerFragment()
    }

    override fun onLocationSelectCanceled() {
        if(mCalendarStore.location.isNull()) {
            finish()
        }
    }

    override fun onLocationSelectFailed(error: String) {
        if (resumed) {
            supportFragmentManager.notFoundById(R.id.container, ToolbarFragment::class) {
                supportFragmentManager.replace(it, ToolbarFragment())
            }

            val view: View = findViewById(R.id.container)
            val snackbar = Snackbar.make(view, error, Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction(R.string.retry) {
                snackbar.dismiss()
                launchCalendarPagerFragment()
            }
            snackbar.show()
        }
    }
}