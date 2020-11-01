package com.sudopk.vc.calendar

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sudopk.vc.retrofit.VcService
import java.util.logging.Logger

private val logger = Logger.getLogger("CalendarApi")

class CalendarApi : ViewModel() {
  private lateinit var mCalendarStore: CalendarStore
  private lateinit var mVcService: VcService
  private val mStatus = MutableLiveData<DataStatus>()

  val calendar: VCalendar
    get() {
      return when (mStatus.value) {
        DataStatus.READY -> mCalendarStore.getCalendar(mMonthYear)
        else -> emptyList()
      }
    }

  private lateinit var mMonthYear: MonthYear


  fun init(vcService: VcService, calendarStore: CalendarStore, monthYear: MonthYear) {
    mVcService = vcService
    mCalendarStore = calendarStore
    mMonthYear = monthYear
  }

  suspend fun fetchCalendar(): LiveData<DataStatus> {
    mStatus.value = DataStatus.NOT_READY
    if (mCalendarStore.hasCalendar(mMonthYear)) {
      mStatus.value = DataStatus.READY
    } else {
      val location = mCalendarStore.location!!

      logger.info("Location: $location")
      try {
        val vCalendar: VCalendar = mVcService.calendar(
          location.id,
          mMonthYear.year,
          "%02d".format(mMonthYear.month)
        )
//          if (!response.isSuccessful) {
//            Log.e("CalendarApi", "Invalid response code: " + response.code())
//            mStatus.value = DataStatus.FAILED
//            return
//          }
//          if (vCalendar == null) {
//            Log.e("CalendarApi", "Empty body")
//            mStatus.value = DataStatus.FAILED
//            return
//          }
        mCalendarStore.saveCalendar(mMonthYear, vCalendar)
        mStatus.value = DataStatus.READY
      } catch (ex: Exception) {
        Log.e(javaClass.simpleName, "Failed to fetch calendar", ex)
        mStatus.value = DataStatus.FAILED
      }
    }
//        override fun onFailure(call: Call<VCalendar>, t: Throwable?) {
//          Log.e("CalenderApi", t?.message!!)
//          mStatus.value = DataStatus.FAILED
//        }
    return mStatus
  }

  fun removeCalendar(monthYear: MonthYear) {
    mCalendarStore.removeCalendar(monthYear)
    mStatus.value = DataStatus.NOT_READY
  }

}

enum class DataStatus {
  NOT_READY, READY, FAILED
}