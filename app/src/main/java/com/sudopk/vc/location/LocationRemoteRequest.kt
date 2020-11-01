package com.sudopk.vc.location

import android.util.Log
import com.sudopk.vc.calendar.Country
import com.sudopk.vc.core.get
import com.sudopk.vc.retrofit.VcService
import java.lang.ref.WeakReference

interface LocationCallback {
  fun onLocationsReceived(countries: List<Country>)

  fun onLocationRequestFailed()
}

class LocationRemoteRequest(private val weakCallback: WeakReference<LocationCallback>) {
  suspend fun makeRequest(vcService: VcService) {
    try {
      val countries = vcService.locations()
      Log.i(javaClass.simpleName, "Received locations: $countries")
      weakCallback.get?.onLocationsReceived(countries)
    } catch (ex: Exception) {
      Log.e(javaClass.simpleName, "Failed to get locations", ex)
      weakCallback.get?.onLocationRequestFailed()
    }
  }
}