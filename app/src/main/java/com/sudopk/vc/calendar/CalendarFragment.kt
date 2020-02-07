package com.sudopk.vc.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sudopk.kandroid.parent
import com.sudopk.vc.R
import com.sudopk.vc.core.vcApp
import kotlinx.android.synthetic.main.calendar.*
import java.util.*


class CalendarFragment : Fragment() {
  private lateinit var mAdapter: CalendarAdapter
  private lateinit var mCalendarApi: CalendarApi
  private lateinit var mMonthYear: MonthYear

  override fun onCreateView(inflater: LayoutInflater,
                            container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.calendar, container, false)
  }

  override fun onStart() {
    super.onStart()
    setHasOptionsMenu(true)
    val vcService = vcApp.vcService
    val calendarStore = vcApp.calendarStore

    mMonthYear = MonthYear(arguments!!.getInt(MONTH), arguments!!.getInt(YEAR))

    recyclerView.layoutManager = LinearLayoutManager(context)
    mAdapter = CalendarAdapter(mMonthYear)
    recyclerView.adapter = mAdapter

    mCalendarApi = ViewModelProviders.of(this).get(CalendarApi::class.java)
    mCalendarApi.init(vcService, calendarStore, mMonthYear)

    fetchCalendar()
  }

  override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    inflater.inflate(R.menu.calendar, menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item.itemId == R.id.refresh) {
      onRefresh()
    } else if (item.itemId == R.id.location) {
      parent<Container>().onChangeLocationRequest()
    }
    return super.onOptionsItemSelected(item)
  }

  fun onRefresh() {
    mCalendarApi.removeCalendar(mMonthYear)
    fetchCalendar()
  }

  fun fetchCalendar() {
    val calendar = mCalendarApi.fetchCalendar()

    calendar.removeObservers(this)
    calendar.observe(this, androidx.lifecycle.Observer {
      when (it) {
        DataStatus.READY -> showCalendar(mCalendarApi.calendar)
        DataStatus.FAILED -> onCalendarRequestFailed()
        else -> onFetchingCalendar()
      }
    })
  }

  fun onFetchingCalendar() {
    viewAnimator.displayedChild = CalendarFragment.CALENDAR_VIEW_INDEX
    progressBar.visibility = View.VISIBLE

  }

  fun onCalendarRequestFailed() {
    progressBar.visibility = View.GONE
    viewAnimator.displayedChild = CalendarFragment.FAILED_VIEW_INDEX
  }

  private fun showCalendar(vCalendar: VCalendar) {
    if (vCalendar.isNotEmpty()) {
      progressBar.visibility = View.GONE

      mAdapter.setData(vCalendar)

      scrollRecyclerViewToCorrectDate()
    } else {
      viewAnimator.displayedChild = CalendarFragment.NO_DATA_VIEW_INDEX
    }
  }

  private fun scrollRecyclerViewToCorrectDate() {
    val calendar = Calendar.getInstance()
    val currentMonth = mMonthYear.month == calendar.get(Calendar.MONTH) + 1 && mMonthYear
      .year ==
      calendar
        .get(Calendar.YEAR)
    if (currentMonth) {
      var positionToScrollTo = calendar.get(Calendar.DATE) - 1   // -1 for 0-based index
      // scroll one before the date
      if (positionToScrollTo > 0) {
        positionToScrollTo--
      }
      recyclerView.layoutManager
        ?.scrollToPosition(positionToScrollTo)

      mAdapter.setDateToHighlight(calendar.get(Calendar.DATE))
    } else {
      mAdapter.setDateToHighlight(0)
    }
  }


  interface Container {
    fun onChangeLocationRequest()
  }

  companion object {
    val CALENDAR_VIEW_INDEX = 0
    val NO_DATA_VIEW_INDEX = 1
    val FAILED_VIEW_INDEX = 2
    private val MONTH = "month"
    private val YEAR = "year"

    /**
     * @param month 1 to 12
     * *
     * @param year  full year e.g. 2016
     */
    fun newInstance(month: Int, year: Int): Fragment {
      val fragment = CalendarFragment()
      val bundle = Bundle()
      bundle.putInt(MONTH, month)
      bundle.putInt(YEAR, year)
      fragment.arguments = bundle
      return fragment
    }
  }
}
