package com.sudopk.vc.retrofit

import com.sudopk.kandroid.StrFromRes
import com.sudopk.vc.calendar.VCalendar
import com.sudopk.vc.location.Location
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit


interface VcService {

    @GET("{locationId}/{year}/{month}")
    @VcApi.Calendar
    fun calendar(@Path("locationId") locationId: String, @Path("year") year: Int, @Path("month") doubleDigitMonth: String):
            Call<VCalendar>

    @GET("/")
    @VcApi.Locations
    fun locations(): Call<List<Location>>

    companion object {
        val URL = "https://www.vaisnavacalendar.com"

        fun newInstance(strFromRes: StrFromRes): VcService {
            val okHttpClient = OkHttpClient.Builder()
              .readTimeout(90, TimeUnit.SECONDS)
              .build()
            return Retrofit.Builder()
                    .baseUrl(VcService.URL)
                    .client(okHttpClient)
                    .addConverterFactory(VcConverterFactory(strFromRes))
                    .build()
                    .create(VcService::class.java)
        }
    }
}
