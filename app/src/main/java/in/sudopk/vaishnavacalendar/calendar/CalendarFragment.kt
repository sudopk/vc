package `in`.sudopk.vaishnavacalendar.calendar

import `in`.sudopk.vaishnavacalendar.*
import `in`.sudopk.vaishnavacalendar.core.castViewById
import `in`.sudopk.vaishnavacalendar.core.parent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.ProgressBar
import android.widget.ViewAnimator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalendarFragment : Fragment(), Callback<VCalendar> {
    private lateinit var mDelegate: CalendarDelegate
    private lateinit var mResumed: CalendarDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        val vcService = vcApp.vcService
        val calendarStore = vcApp.calendarStore

        val year = arguments.getInt(YEAR)
        val month = arguments.getInt(MONTH)

        val view = inflater.inflate(R.layout.calendar, container, false)
        val viewAnimator = view.castViewById<ViewAnimator>(R.id.viewAnimator)
        val progressBar = view.castViewById<ProgressBar>(R.id.progressBar)
        val recyclerView = view.castViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = CalendarAdapter(month, year)
        recyclerView.adapter = adapter

        mDelegate = NoActionCalendar
        mResumed = ResumedCalendar(calendarStore, month, year, parent(), viewAnimator,
                progressBar, vcService, this, adapter, recyclerView)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        inflater.inflate(R.menu.calendar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.refresh) {
            mDelegate.onRefresh()
        } else if (item.itemId == R.id.location) {
            mDelegate.onChangeLocationRequest()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        mDelegate = mResumed
        mDelegate.tryShowingCalendar()
    }

    override fun onPause() {
        super.onPause()
        mDelegate = NoActionCalendar
    }

    override fun onResponse(call: Call<VCalendar>, response: Response<VCalendar>) {
        mDelegate.onCalendarResponse(response.body())
    }

    override fun onFailure(call: Call<VCalendar>, t: Throwable) {
        t.printStackTrace()
        mDelegate.onCalendarRequestFailed()
    }

    interface Container {
        fun onChangeLocationRequest()
    }

    companion object {
        val CALENDAR_VIEW_INDEX = 0
        val NO_DATA_VIEW_INDEX = 1
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
