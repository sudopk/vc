package com.sudopk.vc.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.sudopk.kandroid.appCompatActivity
import com.sudopk.kandroid.parent
import com.sudopk.vc.R
import com.sudopk.vc.core.CalUtil
import com.sudopk.vc.core.vcApp
import com.sudopk.vc.location.Location
import kotlinx.android.synthetic.main.calendar_pager.*
import java.util.*
import kotlinx.coroutines.withContext

class CalendarPagerFragment : Fragment(), CalendarFragment.Container {

  private lateinit var mCalendarStore: CalendarStore

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.calendar_pager, container, false)
  }

  override fun onStart() {
    super.onStart()
    appCompatActivity.setSupportActionBar(toolbar)

    mCalendarStore = vcApp.calendarStore
    updateSubtitle(mCalendarStore.location)

    val pagerAdapter = CalendarPagerAdapter(this)
    viewPager.adapter = pagerAdapter
    viewPager.currentItem = pagerAdapter.itemCount / 2

    TabLayoutMediator(tabs, viewPager) { tab, position ->
      val calendar =
        CalUtil.getCalendar((viewPager.adapter as CalendarPagerAdapter).getMonthOffset(position))
      tab.text = "${calendar.get(Calendar.MONTH) + 1} / ${calendar.get(Calendar.YEAR)}"
    }.attach()
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

private class CalendarPagerAdapter(parentFragment: Fragment) :
  FragmentStateAdapter(parentFragment) {


  override fun createFragment(position: Int): Fragment {
    val calendar = CalUtil.getCalendar(getMonthOffset(position))
    return CalendarFragment.newInstance(
      calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)
    )
  }

  override fun getItemCount(): Int {
    return CalendarStore.MONTHS_TO_STORE
  }

  fun getMonthOffset(position: Int): Int {
    return position - itemCount / 2
  }
}
