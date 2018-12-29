package com.sudopk.vc.location

import com.sudopk.vc.core.get
import com.sudopk.vc.retrofit.VcService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.ref.WeakReference

interface LocationCallback {
    fun onLocationsReceived(locations: List<Location>)

    fun onLocationRequestFailed()

}

class LocationRemoteRequest(val weakCallback: WeakReference<LocationCallback>) {
    fun makeRequest(vcService: VcService) {
        val locationsCall = vcService.locations()
        locationsCall.enqueue(object : Callback<List<Location>> {
            override fun onResponse(call: Call<List<Location>>, response: Response<List<Location>>) {
                if (response.isSuccessful && response.body() != null) {
                    weakCallback.get?.onLocationsReceived(response.body())
                } else {
                    failed()
                }
            }

            override fun onFailure(call: Call<List<Location>>, t: Throwable) {
                t.printStackTrace()
                failed()
            }
        })
    }

    private fun failed() {
        weakCallback.get?.onLocationRequestFailed()
    }
}