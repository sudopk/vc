package com.sudopk.vc.update

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sudopk.kandroid.dialog.ButtonDescription
import com.sudopk.kandroid.dialog.TextDialogFragment
import com.sudopk.kandroid.notFoundByTag
import com.sudopk.kandroid.replace
import com.sudopk.vc.R
import com.sudopk.vc.calendar.VcActivity
import com.sudopk.vc.components.ProgressFragment
import com.sudopk.vc.core.vcApp
import org.jetbrains.anko.startActivity
import kotlinx.android.synthetic.main.container.*

class UpdateCheckActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.container)

        supportFragmentManager.replace(R.id.container, ProgressFragment())

        val api = ViewModelProviders.of(this).get(CheckUpdateApi::class.java)
        api.checkUpdate().observe(this, Observer {
            onConfig(it ?: defaultVcConfig)
        })
    }

    fun onConfig(config: VcConfig) {
        startActivity<VcConfigActivity>(VC_CONFIG to config)

        finish()
    }
}

private val VC_CONFIG = "vcConfig"

private val EXIT_BUTTON_ID = "cancel"
private val UPDATE_BUTTON_ID = "update"
private val IGNORE_BUTTON_ID = "ignore"

class VcConfigActivity : AppCompatActivity(), TextDialogFragment.Container {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handleConfig(intent.extras.get(VC_CONFIG) as VcConfig)
    }

    private fun handleConfig(config: VcConfig) {
        if (vcApp.versionCode() < config.version.hard) {
            showTooOldAppDialog()
        } else if (vcApp.versionCode() < config.version.soft) {
            showRecommendedUpdate()
        } else {
            launchVCalendar()
        }
    }

    private val DIALOG_TAG = "dialogTag";

    private fun showTooOldAppDialog() {
        supportFragmentManager.notFoundByTag(DIALOG_TAG) {
            val dialog = TextDialogFragment.newBlockingInstance(getString(R.string.old_app_must_update),
                    arrayOf(ButtonDescription(EXIT_BUTTON_ID, getString(R.string.exit_app)),
                            ButtonDescription(UPDATE_BUTTON_ID, getString(R.string.update))))
            dialog.show(supportFragmentManager, it)
        }
    }

    private fun showRecommendedUpdate() {
        supportFragmentManager.notFoundByTag(DIALOG_TAG) {
            val dialog = TextDialogFragment.newBlockingInstance(getString(R.string
                    .old_app_recommended_update),
                    arrayOf(ButtonDescription(IGNORE_BUTTON_ID, getString(R.string.ignore)),
                            ButtonDescription(UPDATE_BUTTON_ID, getString(R.string.update))))
            dialog.show(supportFragmentManager, it)
        }
    }

    override fun onDialogButtonClicked(buttonId: String) {
        when (buttonId) {
            UPDATE_BUTTON_ID -> goToPlayStore()
            EXIT_BUTTON_ID -> onDialogCanceled()
            IGNORE_BUTTON_ID -> launchVCalendar()
        }
    }

    fun launchVCalendar() {
        startActivity<VcActivity>()
        finish()
    }

    override fun onDialogCanceled() {
        finish()
    }

    private fun goToPlayStore() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("market://details?id=com.sudopk.vc")
        startActivity(intent)
        finish()
    }
}
