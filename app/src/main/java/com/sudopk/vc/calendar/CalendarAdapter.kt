package com.sudopk.vc.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.sudopk.vc.R
import com.sudopk.vc.core.monthAbbreviation
import com.sudopk.vc.core.weekDayAbbreviation
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.calendar_cell_common.*
import java.util.*
import kotlin.collections.ArrayList


private const val NOT_TODAY_VIEW_TYPE = 0
private const val TODAY_VIEW_TYPE = 1


/**
 * @param month 1 to 12
 * *
 * @param year  Full year e.g. 2016
 */
class CalendarAdapter(private val mMonthYear: MonthYear) : RecyclerView
.Adapter<CalendarAdapter.VH>() {

  private val mVCalendar: MutableList<DayCalendar> = ArrayList()
  private var mDateToHighlight: Int = 0

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
      .inflate(cell, parent, false), eventLayout, mMonthYear)
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

  override fun getItemCount() = mVCalendar.size

  fun setData(calendar: VCalendar) {
    mVCalendar.clear()
    mVCalendar.addAll(calendar)
    Collections.sort(mVCalendar)
    notifyDataSetChanged()
  }

  class VH(itemView: View, @param:LayoutRes private val mEventLayout: Int, monthYear: MonthYear) :
    RecyclerView.ViewHolder(itemView), LayoutContainer {
    private val mMonthCalendar: Calendar

    init {
      mMonthCalendar = Calendar.getInstance()
      mMonthCalendar.set(Calendar.MONTH, monthYear.month - 1)
      mMonthCalendar.set(Calendar.YEAR, monthYear.year)
    }

    override val containerView: View?
      get() = itemView

    fun onBind(dayCalendar: DayCalendar) {
      mMonthCalendar.set(Calendar.DATE, dayCalendar.date)
      date.text = itemView.context.getString(R.string.date_and_weekday,
        mMonthCalendar.monthAbbreviation(), dayCalendar.date,
        mMonthCalendar.weekDayAbbreviation())
      events.setAdapter(ArrayAdapter(itemView.context,
        mEventLayout, dayCalendar.events))
    }
  }
}
