package `in`.sudopk.vaishnavacalendar.retrofit

import com.google.gson.Gson

import `in`.sudopk.vaishnavacalendar.VcConfig
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface VcConfigService {

    @GET(value = "config.json")
    fun config(): Call<VcConfig>

    companion object {
        val URL = "http://sudopk.github.io/vc/"

        fun newInstance(gson: Gson): VcConfigService {
            return Retrofit.Builder()
                    .baseUrl(VcConfigService.URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(VcConfigService::class.java)
        }
    }
}
