package com.sudopk.vc.app

import android.content.pm.PackageManager
import android.support.design.widget.Snackbar
import android.support.multidex.MultiDexApplication
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDialogFragment
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mcxiaoke.koi.KoiConfig
import com.sudopk.kandroid.StrFromRes
import com.sudopk.vc.calendar.CalendarStore
import com.sudopk.vc.gson.RemoveFieldNameStrategy
import com.sudopk.vc.location.LocationStore
import com.sudopk.vc.retrofit.VcService

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

    fun versionCode(): Int {
        try {
            val packageInfo = packageManager.getPackageInfo(packageName, 0)
            return packageInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            throw RuntimeException(e)
        }
    }
}

