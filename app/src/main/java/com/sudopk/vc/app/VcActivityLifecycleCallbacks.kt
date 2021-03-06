package com.sudopk.vc.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VcActivityLifecycleCallbacks @Inject constructor() : Application.ActivityLifecycleCallbacks {
  private var currentResumedActivity: AppCompatActivity? = null

  override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

  override fun onActivityStarted(activity: Activity) {}

  override fun onActivityResumed(activity: Activity) {
    currentResumedActivity = activity as AppCompatActivity
  }

  override fun onActivityPaused(activity: Activity) {
    currentResumedActivity = null
  }

  override fun onActivityStopped(activity: Activity) {}

  override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

  override fun onActivityDestroyed(activity: Activity) {}

  fun currentResumedActivity(): AppCompatActivity? {
    return currentResumedActivity
  }
}
