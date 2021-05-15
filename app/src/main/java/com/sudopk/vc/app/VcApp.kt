package com.sudopk.vc.app

import android.content.pm.PackageManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.content.pm.PackageInfoCompat
import androidx.multidex.MultiDexApplication
import com.google.android.material.snackbar.Snackbar
import com.sudopk.kandroid.StrFromRes
import com.sudopk.vc.calendar.CalendarStore
import com.sudopk.vc.location.LocationStore
import com.sudopk.vc.retrofit.VcService
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class VcApp : MultiDexApplication(), StrFromRes {
  @Inject lateinit var locationStore: LocationStore
  @Inject lateinit var calendarStore: CalendarStore
  @Inject lateinit var vcService: VcService
  @Inject lateinit var lifecycleCallbacks: VcActivityLifecycleCallbacks

  override fun onCreate() {
    super.onCreate()

    registerActivityLifecycleCallbacks(lifecycleCallbacks)
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


