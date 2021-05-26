package com.sudopk.vc.retrofit

import com.sudopk.kandroid.StrFromRes
import com.sudopk.vc.calendar.Country
import com.sudopk.vc.calendar.VCalendar
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path


interface VcService {

  @GET("{locationId}/{year}/{month}")
  @VcApi.Calendar
  suspend fun calendar(
    @Path("locationId") locationId: String,
    @Path("year") year: Int,
    @Path("month") doubleDigitMonth: String
  ):
    VCalendar

  @GET("/")
  @VcApi.Locations
  suspend fun locations(): List<Country>

  companion object {
    val URL = "https://www.vaisnavacalendar.com"

    fun newInstance(strFromRes: StrFromRes): VcService {
      val okHttpClient = OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

      return Retrofit.Builder()
        .baseUrl(URL)
        .client(okHttpClient)
        .addConverterFactory(VcConverterFactory())
        .build()
        .create(VcService::class.java)
    }
  }
}
