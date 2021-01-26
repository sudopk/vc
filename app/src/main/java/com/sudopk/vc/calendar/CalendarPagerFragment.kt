package com.sudopk.vc.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.sudopk.kandroid.appCompatActivity
import com.sudopk.kandroid.parent
import com.sudopk.vc.core.CalUtil
import com.sudopk.vc.core.vcApp
import com.sudopk.vc.databinding.CalendarPagerBinding
import com.sudopk.vc.location.Location
import java.util.Calendar

class CalendarPagerFragment : Fragment(), CalendarFragment.Container {

  private lateinit var mCalendarStore: CalendarStore

  private var _binding: CalendarPagerBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = CalendarPagerBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onStart() {
    super.onStart()
    appCompatActivity.setSupportActionBar(binding.toolbar)

    mCalendarStore = vcApp.calendarStore
    updateSubtitle(mCalendarStore.location)

    val pagerAdapter = CalendarPagerAdapter(this)
    binding.viewPager.adapter = pagerAdapter
    binding.viewPager.currentItem = pagerAdapter.itemCount / 2

    TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
      val calendar =
        CalUtil.getCalendar(
          (binding.viewPager.adapter as CalendarPagerAdapter).getMonthOffset(
            position
          )
        )
      tab.text = "${calendar.get(Calendar.MONTH) + 1} / ${calendar.get(Calendar.YEAR)}"
    }.attach()
  }

  private fun updateSubtitle(location: Location?) {
    if (location != null) {
      binding.toolbar.subtitle = location.name
    } else {
      binding.toolbar.subtitle = ""
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
