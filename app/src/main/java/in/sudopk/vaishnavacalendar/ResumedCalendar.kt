package `in`.sudopk.vaishnavacalendar

import `in`.sudopk.vaishnavacalendar.calendar.CalendarAdapter
import `in`.sudopk.vaishnavacalendar.calendar.CalendarDelegate
import `in`.sudopk.vaishnavacalendar.calendar.CalendarFragment
import `in`.sudopk.vaishnavacalendar.calendar.CalendarStore
import `in`.sudopk.vaishnavacalendar.retrofit.VcService
import android.annotation.SuppressLint
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.ViewAnimator
import retrofit2.Callback
import java.util.*

class ResumedCalendar(private val mCalendarStore: CalendarStore,
                      private val mMonth: Int,
                      private val mYear: Int,
                      private val mContainer: CalendarFragment.Container,
                      private val mViewAnimator: ViewAnimator,
                      private val mProgressBar: ProgressBar,
                      private val mVcService: VcService,
                      private val mCalendarRequestCallback: Callback<VCalendar>,
                      private val mAdapter: CalendarAdapter,
                      private val mRecyclerView: RecyclerView) : CalendarDelegate {

    override fun onChangeLocationRequest() {
        mContainer.onChangeLocationRequest()
    }

    override fun onRefresh() {
        mCalendarStore.removeCalendar(mMonth, mYear)
        tryShowingCalendar()
    }

    override fun tryShowingCalendar() {
        mViewAnimator.displayedChild = CalendarFragment.CALENDAR_VIEW_INDEX
        mProgressBar.visibility = View.VISIBLE

        if (mCalendarStore.hasCalendar(mMonth, mYear)) {
            onCalendarResponse(mCalendarStore.getCalendar(mMonth, mYear))
        } else {
            val location = mCalendarStore.location
            if (location == null) {
                onChangeLocationRequest()
            } else {
                @SuppressLint("DefaultLocale") // The string formatted here is not for end user
                val call = mVcService.calendar(String.format("%02d", mMonth),
                        mYear, "en", location.id)
                call.enqueue(mCalendarRequestCallback)
            }
        }
    }

    override fun onCalendarRequestFailed() {
        mProgressBar.visibility = View.GONE
        Snackbar.make(mRecyclerView, R.string.calender_failure, Snackbar.LENGTH_SHORT).show()
    }

    override fun onCalendarResponse(calendar: VCalendar?) {
        if (calendar != null) {
            mCalendarStore.saveCalendar(mMonth, mYear, calendar)
            showCalendar(calendar)
        } else {
            onCalendarRequestFailed()
        }
    }

    private fun showCalendar(vCalendar: VCalendar) {
        if (vCalendar.hasData()) {
            mProgressBar.visibility = View.GONE
            mAdapter.setData(vCalendar)

            val calendar = Calendar.getInstance()
            val currentMonth = mMonth == calendar.get(Calendar.MONTH) + 1 && mYear == calendar.get(Calendar.YEAR)
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
        } else {
            mViewAnimator.displayedChild = CalendarFragment.NO_DATA_VIEW_INDEX
        }
    }
}
