package com.sudopk.vc.calendar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sudopk.vc.retrofit.VcService
import java.util.logging.Level
import java.util.logging.Logger

private val logger = Logger.getLogger("CalendarApi")

class CalendarApi : ViewModel() {
  private lateinit var mCalendarStore: CalendarStore
  private lateinit var mVcService: VcService
  private lateinit var mMonthYear: MonthYear

  val status = MutableLiveData<DataStatus>(DataStatus.NotReady)

  fun init(vcService: VcService, calendarStore: CalendarStore, monthYear: MonthYear) {
    mVcService = vcService
    mCalendarStore = calendarStore
    mMonthYear = monthYear
  }

  suspend fun fetchCalendar() {
    status.value = DataStatus.NotReady

    if (mCalendarStore.hasCalendar(mMonthYear)) {
      status.value = DataStatus.Ready(mCalendarStore.getCalendar(mMonthYear))
      return
    }

    val location = mCalendarStore.location!!
    logger.info("Location: $location")

    try {
      val vCalendar: VCalendar = mVcService.calendar(
        location.id,
        mMonthYear.year,
        "%02d".format(mMonthYear.month)
      )
      mCalendarStore.saveCalendar(mMonthYear, vCalendar)

      status.value = DataStatus.Ready(vCalendar)
    } catch (ex: Exception) {
      logger.log(Level.WARNING, "Failed to fetch calendar", ex)
      status.value = DataStatus.Failed
    }
  }

  fun removeCalendar(monthYear: MonthYear) {
    mCalendarStore.removeCalendar(monthYear)
    status.value = DataStatus.NotReady
  }
}

sealed class DataStatus {
  object NotReady : DataStatus()
  class Ready(val vCalendar: VCalendar) : DataStatus()
  object Failed : DataStatus()
}