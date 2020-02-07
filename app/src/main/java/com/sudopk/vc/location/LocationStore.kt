package com.sudopk.vc.location

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sudopk.vc.calendar.Country

class LocationStore(context: Context, private val mGson: Gson) {
    private val mPreferences: SharedPreferences
    var locations: List<Country>
        private set

    init {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        val savedLocations = mPreferences.getString(LOCATIONS, "")
        if (savedLocations!!.isBlank()) {
            locations = listOf()
        } else {
            locations = mGson.fromJson<List<Country>>(savedLocations, object : TypeToken<List<Country>>() {}.type)
        }
    }

    fun saveLocations(locations: List<Country>) {
        this.locations = locations
        mPreferences.edit()
                .putString(LOCATIONS, mGson.toJson(locations))
                .apply()
    }

    fun hasLocations(): Boolean {
        return !locations.isEmpty()
    }

    fun cleanupAll() {
        locations = listOf()
    }

    companion object {
        private val LOCATIONS = "locations"
    }
}
