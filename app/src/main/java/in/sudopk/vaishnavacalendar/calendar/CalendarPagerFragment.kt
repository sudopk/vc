package `in`.sudopk.vaishnavacalendar.calendar

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import java.util.Calendar

import `in`.sudopk.coreandroid.Fm
import `in`.sudopk.utils.CalUtil
import `in`.sudopk.vaishnavacalendar.location.Location
import `in`.sudopk.vaishnavacalendar.R
import `in`.sudopk.vaishnavacalendar.core.castViewById
import `in`.sudopk.vaishnavacalendar.vcApp

class CalendarPagerFragment : Fragment(), CalendarFragment.Container {

    private lateinit var mToolbar: Toolbar
    private lateinit var mCalendarStore: CalendarStore
    private lateinit var mViewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.calendar_pager, container, false)

        mToolbar = view.castViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(mToolbar)

        mCalendarStore = vcApp.calendarStore
        updateSubtitle(mCalendarStore.location)

        mViewPager = view.castViewById(R.id.viewPager)
        view.castViewById<TabLayout>(R.id.tabs).setupWithViewPager(mViewPager)

        val pagerAdapter = CalendarPagerAdapter(childFragmentManager)
        mViewPager.adapter = pagerAdapter
        mViewPager.currentItem = pagerAdapter.count / 2
        return view
    }

    private fun updateSubtitle(location: Location?) {
        if (location != null) {
            mToolbar.subtitle = location.name
        } else {
            mToolbar.subtitle = ""
        }
    }

    override fun onChangeLocationRequest() {
        container.onChangeLocationRequest()
    }

    private val container: CalendarPagerFragment.Container
        get() = Fm.container<CalendarPagerFragment.Container>(this)

    interface Container : CalendarFragment.Container

    private inner class CalendarPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

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
            return (calendar.get(Calendar.MONTH) + 1).toString() + " / " + calendar.get(Calendar.YEAR)
        }
    }
}