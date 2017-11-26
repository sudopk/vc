package com.sudopk.vc.calendar

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.ProgressBar
import android.widget.ViewAnimator
import com.mcxiaoke.koi.ext.find
import com.sudopk.kandroid.parent
import com.sudopk.vc.R
import com.sudopk.vc.core.vcApp
import java.util.*

class CalendarFragment : Fragment() {
    private lateinit var mViewAnimator: ViewAnimator
    private lateinit var mProgressBar: ProgressBar
    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mAdapter: CalendarAdapter
    private lateinit var mCalendarApi: CalendarApi
    private lateinit var mMonthYear: MonthYear

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        val vcService = vcApp.vcService
        val calendarStore = vcApp.calendarStore

        mMonthYear = MonthYear(arguments!!.getInt(MONTH), arguments!!.getInt(YEAR))

        val view = inflater.inflate(R.layout.calendar, container, false)
        mViewAnimator = view.find<ViewAnimator>(R.id.viewAnimator)
        mProgressBar = view.find<ProgressBar>(R.id.progressBar)
        mRecyclerView = view.find<RecyclerView>(R.id.recyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = CalendarAdapter(mMonthYear)
        mRecyclerView.adapter = mAdapter

        mCalendarApi = ViewModelProviders.of(this).get(CalendarApi::class.java)
        mCalendarApi.init(vcService, calendarStore, mMonthYear)

        fetchCalendar()

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
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
        calendar.observe(this, android.arch.lifecycle.Observer {
            when (it) {
                DataStatus.READY -> showCalendar(mCalendarApi.calendar)
                DataStatus.FAILED -> onCalendarRequestFailed()
                else -> onFetchingCalendar()
            }
        })
    }

    fun onFetchingCalendar() {
        mViewAnimator.displayedChild = CalendarFragment.CALENDAR_VIEW_INDEX
        mProgressBar.visibility = View.VISIBLE

    }

    fun onCalendarRequestFailed() {
        mProgressBar.visibility = View.GONE
        mViewAnimator.displayedChild = CalendarFragment.FAILED_VIEW_INDEX
    }

    private fun showCalendar(vCalendar: VCalendar) {
        if (vCalendar.isNotEmpty()) {
            mProgressBar.visibility = View.GONE

            mAdapter.setData(vCalendar)

            scrollRecyclerViewToCorrectDate()
        } else {
            mViewAnimator.displayedChild = CalendarFragment.NO_DATA_VIEW_INDEX
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
            mRecyclerView.layoutManager
                    .scrollToPosition(positionToScrollTo)

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
