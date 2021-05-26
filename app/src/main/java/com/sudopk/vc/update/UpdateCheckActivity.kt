package com.sudopk.vc.update

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sudopk.kandroid.dialog.ButtonDescription
import com.sudopk.kandroid.dialog.TextDialogFragment
import com.sudopk.kandroid.notFoundByTag
import com.sudopk.vc.R
import com.sudopk.vc.calendar.VcActivity
import com.sudopk.vc.core.vcApp

class UpdateCheckActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LinearProgressIndicator(Modifier.fillMaxWidth())
      }
    }

    val api = ViewModelProviders.of(this).get(CheckUpdateApi::class.java)
    api.checkUpdate().observe(this, Observer {
      onConfig(it ?: defaultVcConfig)
    })
  }

  fun onConfig(config: VcConfig) {
    startActivity(Intent(this, VcConfigActivity::class.java).also {
      it.putExtra(VC_CONFIG, config)
    })

    finish()
  }
}

private val VC_CONFIG = "vcConfig"

private val EXIT_BUTTON_ID = "cancel"
private val UPDATE_BUTTON_ID = "update"
private val IGNORE_BUTTON_ID = "ignore"

private val DIALOG_TAG = "dialogTag"

class VcConfigActivity : AppCompatActivity(), TextDialogFragment.Container {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    handleConfig(intent.extras!!.get(VC_CONFIG) as VcConfig)
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

  private fun showTooOldAppDialog() {
    supportFragmentManager.notFoundByTag(DIALOG_TAG) {
      val dialog = TextDialogFragment.newBlockingInstance(
        getString(R.string.old_app_must_update),
        arrayOf(
          ButtonDescription(EXIT_BUTTON_ID, getString(R.string.exit_app)),
          ButtonDescription(UPDATE_BUTTON_ID, getString(R.string.update))
        )
      )
      dialog.show(supportFragmentManager, it)
    }
  }

  private fun showRecommendedUpdate() {
    supportFragmentManager.notFoundByTag(DIALOG_TAG) {
      val dialog = TextDialogFragment.newBlockingInstance(
        getString(
          R.string
            .old_app_recommended_update
        ),
        arrayOf(
          ButtonDescription(IGNORE_BUTTON_ID, getString(R.string.ignore)),
          ButtonDescription(UPDATE_BUTTON_ID, getString(R.string.update))
        )
      )
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
    startActivity(Intent(this, VcActivity::class.java))
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
