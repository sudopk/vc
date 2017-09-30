package `in`.sudopk.vaishnavacalendar

import `in`.sudopk.coreandroid.StrFromRes
import `in`.sudopk.vaishnavacalendar.calendar.CalendarStore
import `in`.sudopk.vaishnavacalendar.gson.RemoveFieldNameStrategy
import `in`.sudopk.vaishnavacalendar.location.LocationStore
import `in`.sudopk.vaishnavacalendar.retrofit.VcService
import android.content.pm.PackageManager
import android.support.design.widget.Snackbar
import android.support.multidex.MultiDexApplication
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDialogFragment
import com.google.gson.Gson
import com.google.gson.GsonBuilder

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


