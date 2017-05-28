package `in`.sudopk.vaishnavacalendar.location

import `in`.sudopk.vaishnavacalendar.calendar.Country
import `in`.sudopk.vaishnavacalendar.core.Mortal
import `in`.sudopk.vaishnavacalendar.core.get
import `in`.sudopk.vaishnavacalendar.retrofit.VcService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.ref.WeakReference

interface LocationCallback {
    fun onLocationsReceived(countries: List<Country>)

    fun onLocationRequestFailed()

}

class LocationRemoteRequest(val weakCallback: WeakReference<LocationCallback>) {
    fun makeRequest(vcService: VcService) {
        val locationsCall = vcService.locations()
        locationsCall.enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                    if (response.body() != null) {
                        weakCallback.get?.onLocationsReceived(response.body())
                    } else {
                        failed()
                    }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                t.printStackTrace()
                failed()
            }
        })
    }

    private fun failed() {
        weakCallback.get?.onLocationRequestFailed()
    }
}