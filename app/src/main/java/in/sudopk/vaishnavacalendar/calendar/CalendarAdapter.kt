package `in`.sudopk.vaishnavacalendar.calendar

import `in`.sudopk.coreandroid.SimpleList
import `in`.sudopk.utils.CalUtil
import `in`.sudopk.vaishnavacalendar.R
import `in`.sudopk.vaishnavacalendar.VCalendar
import `in`.sudopk.vaishnavacalendar.core.castViewById
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.util.*


/**
 * @param month 1 to 12
 * *
 * @param year  Full year e.g. 2016
 */
class CalendarAdapter(private val mMonth: Int, private val mYear: Int) : RecyclerView
.Adapter<CalendarAdapter.VH>() {

    private val mVCalendar: MutableList<DayCalendar>
    private var mDateToHighlight: Int = 0


    init {
        mVCalendar = ArrayList<DayCalendar>()
    }

    /**
     * @param dateToHighlight Month dates i.e. 1 to 31. Pass 0 if don't want to highlight any date
     */
    fun setDateToHighlight(dateToHighlight: Int) {
        mDateToHighlight = dateToHighlight
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val cell: Int
        val eventLayout: Int
        if (viewType == NOT_TODAY_VIEW_TYPE) {
            cell = R.layout.calendar_cell
            eventLayout = R.layout.text_view
        } else {
            cell = R.layout.calendar_cell_today
            eventLayout = R.layout.text_view
        }
        return VH(LayoutInflater.from(parent.context)
                .inflate(cell, parent, false), eventLayout, mMonth, mYear)
    }

    override fun getItemViewType(position: Int): Int {
        val cal = mVCalendar[position]
        if (cal.date == mDateToHighlight) {
            return TODAY_VIEW_TYPE
        } else {
            return NOT_TODAY_VIEW_TYPE
        }
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(mVCalendar[position])
    }

    override fun getItemCount(): Int {
        return mVCalendar.size
    }

    fun setData(calendar: VCalendar) {
        mVCalendar.clear()
        mVCalendar.addAll(calendar.calendar)
        Collections.sort(mVCalendar)
        notifyDataSetChanged()
    }

    class VH(itemView: View, @param:LayoutRes private val mEventLayout: Int, month: Int, year: Int) : RecyclerView.ViewHolder(itemView) {
        private val mEvents: SimpleList
        private val mDate: TextView
        private val mMonthCalendar: Calendar

        init {
            mDate = itemView.castViewById(R.id.date)
            mEvents = itemView.castViewById(R.id.events)

            mMonthCalendar = Calendar.getInstance()
            mMonthCalendar.set(Calendar.MONTH, month - 1)
            mMonthCalendar.set(Calendar.YEAR, year)
        }

        fun onBind(dayCalendar: DayCalendar) {
            mMonthCalendar.set(Calendar.DATE, dayCalendar.date)
            mDate.text = itemView.context.getString(R.string.date_and_weekday, CalUtil
                    .monthAbbreviation(mMonthCalendar), dayCalendar.date, CalUtil.weekDayAbbreviation
            (mMonthCalendar))
            mEvents.setAdapter(ArrayAdapter(itemView.context,
                    mEventLayout, dayCalendar.events))
        }
    }

    companion object {
        private val TAG = "CalendarAdapter"
        private val NOT_TODAY_VIEW_TYPE = 0
        private val TODAY_VIEW_TYPE = 1
    }
}
