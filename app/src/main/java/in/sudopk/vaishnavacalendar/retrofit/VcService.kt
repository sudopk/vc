package `in`.sudopk.vaishnavacalendar.retrofit

import `in`.sudopk.vaishnavacalendar.calendar.Country
import `in`.sudopk.vaishnavacalendar.VCalendar
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface VcService {

    @GET("vcal.php")
    @VcApi.Calendar
    fun calendar(@Query("month") month: String, @Query("year") year: Int,
                 @Query("lang") lang: String, @Query("CIID") locationId: String): Call<VCalendar>

    @GET("vcal.php")
    @VcApi.Locations
    fun locations(): Call<List<Country>>

    companion object {
        val URL = "http://www.vaisnavacalendar.com/"

        fun newInstance(): VcService {
            return Retrofit.Builder()
                    .baseUrl(VcService.URL)
                    .addConverterFactory(VcConverterFactory())
                    .build()
                    .create(VcService::class.java)
        }
    }
}
