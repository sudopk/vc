package com.sudopk.vaishnavacalendar

import com.sudopk.vaishnavacalendar.calendar.CalendarPagerFragment
import com.sudopk.vaishnavacalendar.calendar.CalendarStore
import com.sudopk.vaishnavacalendar.core.ifResumed
import com.sudopk.vaishnavacalendar.core.replace
import com.sudopk.vaishnavacalendar.core.resumed
import com.sudopk.vaishnavacalendar.core.vcApp
import com.sudopk.vaishnavacalendar.location.Location
import com.sudopk.vaishnavacalendar.location.LocationContainer
import com.sudopk.vaishnavacalendar.location.LocationFragment
import com.sudopk.vaishnavacalendar.retrofit.VcConfigService
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VcActivity : AppCompatActivity(),
        CalendarPagerFragment.Container,
        LocationContainer,
        TextDialog.Container {
    private lateinit var mCalendarStore: CalendarStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.container)

        mCalendarStore = vcApp.calendarStore

        if (savedInstanceState == null) {
            launchCalendarPagerFragment()
        }
    }

    override fun onResume() {
        super.onResume()
        checkForVersion()
    }

    private fun showTooOldAppDialog() {
        ifResumed {
            dismissLocationDialog()
            val tag = "BlockingDialog"
            if (supportFragmentManager.findFragmentByTag(tag) == null) {
                val dialog = TextDialog.newBlockingInstance(getString(R.string.old_app_must_update),
                        arrayOf(ButtonDescription(EXIT_BUTTON_ID, getString(R.string.exit)),
                                ButtonDescription(UPDATE_BUTTON_ID, getString(R.string.update))))
                dialog.show(supportFragmentManager, tag)
            }
        }
    }

    override fun onDialogButtonClicked(buttonId: String) {
        when (buttonId) {
            UPDATE_BUTTON_ID -> goToPlayStore()
            EXIT_BUTTON_ID -> onDialogCanceled()
        }
    }

    private fun goToPlayStore() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("market://details?id=com.sudopk.vc")
        startActivity(intent)
    }

    override fun onDialogCanceled() {
        onBackPressed()
    }


    private fun checkForVersion() {
        val configService = VcConfigService.newInstance(vcApp
                .gson).config()
        configService.enqueue(object : Callback<VcConfig> {
            override fun onResponse(call: Call<VcConfig>, response: Response<VcConfig>) {
                val config = response.body()
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
        if (resumed) {
            dismissLocationDialog()
            val view = findViewById(R.id.container)
            val snackbar = Snackbar.make(view, getString(R.string.old_app_recommended_update),
                    Snackbar.LENGTH_LONG)
            snackbar.setAction(R.string.update) { goToPlayStore() }
            snackbar.show()
        }
    }

    private fun dismissLocationDialog() {
        val fragment = fragmentManager.findFragmentByTag(LocationFragment.TAG)
                as DialogFragment?
        if (fragment != null && fragment.isVisible) {
            fragment.dismiss();
        }
    }

    private fun launchCalendarPagerFragment() {
        supportFragmentManager.replace(R.id.container, CalendarPagerFragment())
    }

    override fun onChangeLocationRequest() {
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

    override fun onLocationSelectFailed(error: String) {
        if(resumed) {
            val view = findViewById(R.id.container)
            Snackbar.make(view, error, Snackbar.LENGTH_LONG).show()
        }
    }

    companion object {
        private val EXIT_BUTTON_ID = "cancel"
        private val UPDATE_BUTTON_ID = "ok"
    }
}
