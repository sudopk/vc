package com.sudopk.vc.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

internal class VcActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks {
  private var mCurrentResumedActivity: AppCompatActivity? = null
  override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

  }

  override fun onActivityStarted(activity: Activity) {

  }

  override fun onActivityResumed(activity: Activity) {
    mCurrentResumedActivity = activity as AppCompatActivity
  }

  override fun onActivityPaused(activity: Activity) {
    mCurrentResumedActivity = null
  }

  override fun onActivityStopped(activity: Activity) {

  }

  override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

  }

  override fun onActivityDestroyed(activity: Activity) {

  }

  fun currentResumedActivity(): AppCompatActivity? {
    return mCurrentResumedActivity
  }
}
