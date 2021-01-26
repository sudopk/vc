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
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.sudopk.kandroid.parent
import com.sudopk.vc.R
import com.sudopk.vc.databinding.CalendarBinding
import com.sudopk.vc.retrofit.VcService
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import javax.inject.Inject
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CalendarFragment : Fragment() {
  @Inject lateinit var calendarStore: CalendarStore
  @Inject lateinit var vcService: VcService

  private lateinit var mAdapter: CalendarAdapter
  private lateinit var mCalendarApi: CalendarApi
  private lateinit var mMonthYear: MonthYear
  private var _binding: CalendarBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = CalendarBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onStart() {
    super.onStart()
    setHasOptionsMenu(true)
    mMonthYear = MonthYear(requireArguments().getInt(MONTH), requireArguments().getInt(YEAR))

    binding.recyclerView.layoutManager = LinearLayoutManager(context)
    mAdapter = CalendarAdapter(mMonthYear)
    binding.recyclerView.adapter = mAdapter

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

  private fun onRefresh() {
    mCalendarApi.removeCalendar(mMonthYear)
    fetchCalendar()

  }

  private fun fetchCalendar() {
    lifecycleScope.launch {
      val calendar = mCalendarApi.fetchCalendar()

      calendar.removeObservers(this@CalendarFragment)
      calendar.observe(this@CalendarFragment, {
        when (it) {
          DataStatus.READY -> showCalendar(mCalendarApi.calendar)
          DataStatus.FAILED -> onCalendarRequestFailed()
          else -> onFetchingCalendar()
        }
      })
    }
  }

  fun onFetchingCalendar() {
    binding.viewAnimator.displayedChild = CALENDAR_VIEW_INDEX
    binding.progressBar.visibility = View.VISIBLE

  }

  private fun onCalendarRequestFailed() {
    binding.progressBar.visibility = View.GONE
    binding.viewAnimator.displayedChild = FAILED_VIEW_INDEX
  }

  private fun showCalendar(vCalendar: VCalendar) {
    if (vCalendar.isNotEmpty()) {
      binding.progressBar.visibility = View.GONE

      mAdapter.setData(vCalendar)

      scrollRecyclerViewToCorrectDate()
    } else {
      binding.viewAnimator.displayedChild = NO_DATA_VIEW_INDEX
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
      binding.recyclerView.layoutManager
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
    const val CALENDAR_VIEW_INDEX = 0
    const val NO_DATA_VIEW_INDEX = 1
    const val FAILED_VIEW_INDEX = 2
    private const val MONTH = "month"
    private const val YEAR = "year"

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
