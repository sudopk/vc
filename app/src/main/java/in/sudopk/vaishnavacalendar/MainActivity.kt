package `in`.sudopk.vaishnavacalendar

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import `in`.sudopk.coreandroid.Fm
import `in`.sudopk.vaishnavacalendar.calendar.CalendarPagerFragment
import `in`.sudopk.vaishnavacalendar.calendar.CalendarStore
import `in`.sudopk.vaishnavacalendar.location.Location
import `in`.sudopk.vaishnavacalendar.location.LocationContainer
import `in`.sudopk.vaishnavacalendar.location.LocationFragment
import `in`.sudopk.vaishnavacalendar.retrofit.VcConfigService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), CalendarPagerFragment.Container, LocationContainer, TextDialog.Container {
    private lateinit var mCalendarStore: CalendarStore
    /**
     * Do not name this method 'isResumed', there would be a crash.
     * Actually isResumed() is already a method in some super class but is hidden (@hide)
     * Crash:
     * Theme: themes:{default=overlay:system, iconPack:system, fontPkg:system, com.android.systemui=overlay:system, com.android.systemui.navbar=overlay:system}
     * java.lang.LinkageError
     * http://stackoverflow.com/questions/34061704/java-lang-linkageerror-mainactivity
     */
    protected var isActivityResumed: Boolean = false
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container)

        mCalendarStore = (application as VcApp).calendarStore

        if (savedInstanceState == null) {
            launchCalendarPagerFragment()
        }
    }

    override fun onResume() {
        super.onResume()
        isActivityResumed = true
        checkForVersion()
    }

    override fun onPause() {
        super.onPause()
        isActivityResumed = false
    }

    private fun showTooOldAppDialog() {
        if (isActivityResumed) {
            val tag = "BlockingDialog"
            if (supportFragmentManager.findFragmentByTag(tag) == null) {
                //            TODO use res
                val dialog = TextDialog.newBlockingInstance("This version of the app is " + "too old and must be updated.",
                        arrayOf(ButtonDescription("Exit", EXIT_BUTTON_ID), ButtonDescription("Update", UPDATE_BUTTON_ID)))
                dialog.show(supportFragmentManager, tag)
            }
        }
    }

    override fun onDialogButtonClicked(buttonId: String) {
        when (buttonId) {
            UPDATE_BUTTON_ID -> goToPlayStore()
            EXIT_BUTTON_ID -> onDialogCanceled()
            else -> {
            }
        }
    }

    private fun goToPlayStore() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("market://details?id=com.waze")
        startActivity(intent)
    }

    override fun onDialogCanceled() {
        onBackPressed()
    }


    private fun checkForVersion() {
        val configService = VcConfigService.newInstance((application as VcApp)
                .gson).config()
        configService.enqueue(object : Callback<VcConfig> {
            override fun onResponse(call: Call<VcConfig>, response: Response<VcConfig>) {
                val config = response.body()
                val vcApp = application as VcApp
                if (vcApp.versionCode() < config.version.hard) {
                    showTooOldAppDialog()
                } else if (vcApp.versionCode() < config.version.soft) {
                    showRecommendedUpdate()
                }
            }

            override fun onFailure(call: Call<VcConfig>, t: Throwable) {
                // no-op
            }
        })
    }

    private fun showRecommendedUpdate() {
        if (isActivityResumed) {
            val snackbar = Snackbar.make(findViewById(R.id.container), "App seems old." + " Recommended to update.",
                    Snackbar.LENGTH_LONG)
            snackbar.setAction("UPDATE") { v -> goToPlayStore() }
            snackbar.show()
        }
    }

    private fun launchCalendarPagerFragment() {
        Fm.replace(supportFragmentManager, R.id.container, CalendarPagerFragment())
    }

    override fun onChangeLocationRequest() {
        // TODO handle when there is blocking update
        val fragmentManager = supportFragmentManager
        try {
            // throws IllegalStateException, for reason which is not clear to me
            fragmentManager.executePendingTransactions()
        } catch (ex: IllegalStateException) {
            ex.printStackTrace()
        }

        var fragment = fragmentManager.findFragmentByTag(LocationFragment.TAG)
                as DialogFragment?
        if (fragment == null) {
            fragment = LocationFragment.newInstance()
            fragment.show(fragmentManager, LocationFragment.TAG)
        }
    }

    override fun onLocationSelected(location: Location) {
        mCalendarStore.location = location
        launchCalendarPagerFragment()
    }

    override fun onLocationSelectCanceled() {
        if (mCalendarStore.location == null) {
            Toast.makeText(this, R.string.location_required, Toast.LENGTH_LONG).show()
            onChangeLocationRequest()
        }
    }

    companion object {
        private val EXIT_BUTTON_ID = "cancel"
        private val UPDATE_BUTTON_ID = "ok"
    }
}
