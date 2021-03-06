package com.sudopk.vc.core

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sudopk.vc.app.VcApp


val Activity.vcApp
  get() = application as VcApp

val Fragment.vcApp
  get() = activity!!.vcApp

/**
 * Do not name this method 'isResumed', there would be a crash.
 * Actually isResumed() is already a method in some super class but is hidden (@hide)
 * Crash:
 * Theme: themes:{default=overlay:system, iconPack:system, fontPkg:system, com.android.systemui=overlay:system, com.android.systemui.navbar=overlay:system}
 * java.lang.LinkageError
 * http://stackoverflow.com/questions/34061704/java-lang-linkageerror-mainactivity
 */
val AppCompatActivity.resumed
  get() = vcApp.currentResumedActivity() === this

inline fun AppCompatActivity.ifResumed(block: () -> Unit) {
  if (resumed) {
    block()
  }
}
