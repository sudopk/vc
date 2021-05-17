package com.sudopk.vc.location

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sudopk.vc.calendar.Country
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocationStore @Inject constructor(
  @ApplicationContext context: Context,
  private val mGson: Gson
) {
  private val mPreferences: SharedPreferences =
    PreferenceManager.getDefaultSharedPreferences(context)
  var locations: List<Country>
    private set

  init {
    val savedLocations = mPreferences.getString(LOCATIONS, "")
    locations = if (savedLocations!!.isBlank()) {
      listOf()
    } else {
      mGson.fromJson(savedLocations, object : TypeToken<List<Country>>() {}.type)
    }
  }

  fun saveLocations(locations: List<Country>) {
    this.locations = locations
    mPreferences.edit {
      putString(LOCATIONS, mGson.toJson(locations))
    }
  }

  fun hasLocations(): Boolean {
    return locations.isNotEmpty()
  }

  fun cleanupAll() {
    locations = listOf()
  }

  companion object {
    private val LOCATIONS = "locations"
  }
}
