package com.sudopk.vc.calendar

import androidx.lifecycle.MutableLiveData
import com.sudopk.vc.retrofit.VcService
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import java.util.logging.Level
import java.util.logging.Logger

private val logger = Logger.getLogger("CalendarApi")

@AssistedFactory
interface CalendarApiFactory {
  fun create(monthYear: MonthYear): CalendarApi
}

class CalendarApi @AssistedInject constructor(
  private val calendarStore: CalendarStore, private val vcService: VcService,
  @Assisted val monthYear: MonthYear
) {
  val status = MutableLiveData<DataStatus>(DataStatus.NotReady)

  suspend fun fetchCalendar() {
    status.value = DataStatus.NotReady

    if (calendarStore.hasCalendar(monthYear)) {
      status.value = DataStatus.Ready(calendarStore.getCalendar(monthYear))
      return
    }

    val location = calendarStore.location!!
    logger.info("Location: $location")

    try {
      val vCalendar: VCalendar = vcService.calendar(
        location.id,
        monthYear.year,
        "%02d".format(monthYear.month)
      )
      calendarStore.saveCalendar(monthYear, vCalendar)

      status.value = DataStatus.Ready(vCalendar)
    } catch (ex: Exception) {
      logger.log(Level.WARNING, "Failed to fetch calendar", ex)
      status.value = DataStatus.Failed
    }
  }

  fun removeCalendar() {
    calendarStore.removeCalendar(monthYear)
    status.value = DataStatus.NotReady
  }
}

sealed class DataStatus {
  object NotReady : DataStatus()
  class Ready(val vCalendar: VCalendar) : DataStatus()
  object Failed : DataStatus()
}