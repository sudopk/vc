package com.sudopk.vc.calendar

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sudopk.kandroid.appCompatActivity
import com.sudopk.kandroid.parent
import com.sudopk.vc.R
import com.sudopk.vc.core.CalUtil
import com.sudopk.vc.core.vcApp
import com.sudopk.vc.location.Location
import kotlinx.android.synthetic.main.calendar_pager.*
import java.util.*

class CalendarPagerFragment : Fragment(), CalendarFragment.Container {

    private lateinit var mCalendarStore: CalendarStore

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.calendar_pager, container, false)
    }

    override fun onStart() {
        super.onStart()
        appCompatActivity.setSupportActionBar(toolbar)

        mCalendarStore = vcApp.calendarStore
        updateSubtitle(mCalendarStore.location)

        tabs.setupWithViewPager(viewPager)

        val pagerAdapter = CalendarPagerAdapter(childFragmentManager)
        viewPager.adapter = pagerAdapter
        viewPager.currentItem = pagerAdapter.count / 2
    }

    private fun updateSubtitle(location: Location?) {
        if (location != null) {
            toolbar.subtitle = location.name
        } else {
            toolbar.subtitle = ""
        }
    }

    override fun onChangeLocationRequest() {
        parent<Container>().onChangeLocationRequest()
    }

    interface Container : CalendarFragment.Container
}

private class CalendarPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val calendar = CalUtil.getCalendar(getMonthOffset(position))
        return CalendarFragment.newInstance(
                calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR))
    }

    override fun getCount(): Int {
        return CalendarStore.MONTHS_TO_STORE
    }

    private fun getMonthOffset(position: Int): Int {
        return position - count / 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        val calendar = CalUtil.getCalendar(getMonthOffset(position))
        return "${calendar.get(Calendar.MONTH) + 1} / ${calendar.get(Calendar.YEAR)}"
    }
}
