package com.sudopk.vc.retrofit

import com.sudopk.kandroid.StrFromRes
import com.sudopk.vc.calendar.VCalendar
import com.sudopk.vc.location.Location
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface VcService {

    @GET("{locationId}/{year}/{month}")
    @VcApi.Calendar
    fun calendar(@Path("locationId") locationId: String, @Path("year") year: Int, @Path("month") month: Int):
            Call<VCalendar>

    @GET("/")
    @VcApi.Locations
    fun locations(): Call<List<Location>>

    companion object {
        val URL = "http://www.vaisnavacalendar.com"

        fun newInstance(strFromRes: StrFromRes): VcService {
            return Retrofit.Builder()
                    .baseUrl(VcService.URL)
                    .addConverterFactory(VcConverterFactory(strFromRes))
                    .build()
                    .create(VcService::class.java)
        }
    }
}
