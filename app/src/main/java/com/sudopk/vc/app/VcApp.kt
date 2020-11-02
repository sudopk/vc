package com.sudopk.vc.app

import android.content.pm.PackageManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.content.pm.PackageInfoCompat
import androidx.multidex.MultiDexApplication
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.mcxiaoke.koi.KoiConfig
import com.sudopk.kandroid.StrFromRes
import com.sudopk.vc.calendar.CalendarStore
import com.sudopk.vc.di.DaggerVcComponent
import com.sudopk.vc.di.VcComponent
import com.sudopk.vc.di.VcModule
import com.sudopk.vc.location.LocationStore
import com.sudopk.vc.retrofit.VcService
import javax.inject.Inject
import org.jetbrains.anko.defaultSharedPreferences

class VcApp : MultiDexApplication(), StrFromRes {
  @Inject lateinit var gson: Gson
  @Inject lateinit var locationStore: LocationStore
  @Inject lateinit var calendarStore: CalendarStore
  @Inject lateinit var vcService: VcService
  @Inject lateinit var lifecycleCallbacks: VcActivityLifecycleCallbacks

  lateinit var vcComponent: VcComponent

  override fun onCreate() {
    super.onCreate()
    vcComponent = DaggerVcComponent.builder().vcModule(VcModule(this)).build()

    vcComponent.inject(this)

    registerActivityLifecycleCallbacks(lifecycleCallbacks)

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
      val snackbar = Snackbar.make(
        activity.window.decorView, "", Snackbar
          .LENGTH_SHORT
      )
      snackbar.show()
    }
  }

  fun currentResumedActivity(): AppCompatActivity? {
    return lifecycleCallbacks.currentResumedActivity()
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


