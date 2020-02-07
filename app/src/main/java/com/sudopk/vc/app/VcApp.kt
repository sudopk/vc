package com.sudopk.vc.app

import android.content.pm.PackageManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.content.pm.PackageInfoCompat
import androidx.multidex.MultiDexApplication
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mcxiaoke.koi.KoiConfig
import com.sudopk.kandroid.StrFromRes
import com.sudopk.vc.calendar.CalendarStore
import com.sudopk.vc.gson.RemoveFieldNameStrategy
import com.sudopk.vc.location.LocationStore
import com.sudopk.vc.retrofit.VcService
import org.jetbrains.anko.defaultSharedPreferences

class VcApp : MultiDexApplication(), StrFromRes {
    lateinit var gson: Gson
    lateinit var locationStore: LocationStore
    lateinit var calendarStore: CalendarStore
    lateinit var vcService: VcService
    private lateinit var mLifecycleCallbacks: VcActivityLifecycleCallbacks

    override fun onCreate() {
        super.onCreate()
        mLifecycleCallbacks = VcActivityLifecycleCallbacks()
        registerActivityLifecycleCallbacks(mLifecycleCallbacks)

        gson = GsonBuilder()
                .setFieldNamingStrategy(RemoveFieldNameStrategy())
                .create()
        vcService = VcService.newInstance(this)

        calendarStore = CalendarStore(this, gson)
        locationStore = LocationStore(this, gson)

        val cleanedupKeyVersionCode3 = "CleanupVersionCode3"
        val cleanedup = defaultSharedPreferences.getBoolean(cleanedupKeyVersionCode3, false)
        if (!cleanedup) {
            calendarStore.cleanupAll()
            locationStore.cleanupAll()
            defaultSharedPreferences.edit().putBoolean(cleanedupKeyVersionCode3, true).apply()
        }

        KoiConfig.logLevel = Log.DEBUG
    }

    fun showBlockingNotification() {
        val activity = currentResumedActivity()
        if (activity != null) {
            val fm = activity.supportFragmentManager
            val dialogFragment = AppCompatDialogFragment()
            dialogFragment.isCancelable = false
            dialogFragment.show(fm, null)
        }
    }

    fun showSoftNotification() {
        val activity = currentResumedActivity()

        if (activity != null) {
            val snackbar = Snackbar.make(activity.window.decorView, "", Snackbar
                    .LENGTH_SHORT)
            snackbar.show()
        }
    }

    fun currentResumedActivity(): AppCompatActivity? {
        return mLifecycleCallbacks.currentResumedActivity()
    }

  fun versionCode(): Long {
    try {
      val packageInfo = packageManager.getPackageInfo(packageName, 0)
      val longVersionCode = PackageInfoCompat.getLongVersionCode(packageInfo)
      Log.e("VersionCode", "${longVersionCode}")
      return longVersionCode
    } catch (e: PackageManager.NameNotFoundException) {
      throw RuntimeException(e)
    }
  }
}


