package com.sudopk.vc.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sudopk.vc.R
import com.sudopk.vc.core.monthAbbreviation
import com.sudopk.vc.core.weekDayAbbreviation
import com.sudopk.vc.databinding.CalendarCellBinding
import com.sudopk.vc.databinding.CalendarCellCommonBinding
import com.sudopk.vc.databinding.CalendarCellTodayBinding
import java.util.Calendar


private const val NOT_TODAY_VIEW_TYPE = 0
private const val TODAY_VIEW_TYPE = 1


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
    val binding: CalendarCellCommonBinding
    val rootView: View
    if (viewType == NOT_TODAY_VIEW_TYPE) {
      val cellBinding =
        CalendarCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      binding = cellBinding.common
      rootView = cellBinding.root
    } else {
      val cellBinding =
        CalendarCellTodayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      binding = cellBinding.common
      rootView = cellBinding.root
    }
    return VH(rootView, binding, mMonthYear)
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
    mVCalendar.sort()
    notifyDataSetChanged()
  }

  class VH(
    itemView: View,
    private val binding: CalendarCellCommonBinding,
    monthYear: MonthYear
  ) : RecyclerView.ViewHolder(itemView) {
    private val mMonthCalendar: Calendar = Calendar.getInstance()

    init {
      mMonthCalendar.set(Calendar.MONTH, monthYear.month - 1)
      mMonthCalendar.set(Calendar.YEAR, monthYear.year)
    }

    fun onBind(dayCalendar: DayCalendar) {
      mMonthCalendar.set(Calendar.DATE, dayCalendar.date)
      binding.date.text = itemView.context.getString(
        R.string.date_and_weekday,
        mMonthCalendar.monthAbbreviation(), dayCalendar.date,
        mMonthCalendar.weekDayAbbreviation()
      )
      binding.events.setAdapter(
        ArrayAdapter(itemView.context, R.layout.text_view, dayCalendar.events)
      )
    }
  }
}
