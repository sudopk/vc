package com.sudopk.vc.calendar

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.sudopk.vc.retrofit.VcService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    fun fetchCalendar(): LiveData<DataStatus> {
        mStatus.value = DataStatus.NOT_READY
        if (mCalendarStore.hasCalendar(mMonthYear)) {
            mStatus.value = DataStatus.READY
        } else {
            @SuppressLint("DefaultLocale") // The string formatted here is not for end user
            val call = mVcService.calendar(String.format("%02d", mMonthYear.month),
                    mMonthYear.year, "en", mCalendarStore.location!!.id)
            call.enqueue(object : Callback<VCalendar> {
                override fun onResponse(call: Call<VCalendar>, response: Response<VCalendar>) {
                    if (!response.isSuccessful) {
                        Log.e("CalendarApi", "Invalid response code: " + response.code())
                        mStatus.value = DataStatus.FAILED
                        return
                    }
                    if (response.body() == null) {
                        Log.e("CalendarApi", "Empty body")
                        mStatus.value = DataStatus.FAILED
                        return
                    }
                    mCalendarStore.saveCalendar(mMonthYear, response.body())
                    mStatus.value = DataStatus.READY
                }

                override fun onFailure(call: Call<VCalendar>, t: Throwable?) {
                    mStatus.value = DataStatus.FAILED
                }
            })
        }
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