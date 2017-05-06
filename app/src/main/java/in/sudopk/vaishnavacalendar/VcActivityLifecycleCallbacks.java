package in.sudopk.vaishnavacalendar;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

class VcActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private AppCompatActivity mCurrentResumedActivity;
    @Override
    public void onActivityCreated(final Activity activity, final Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(final Activity activity) {

    }

    @Override
    public void onActivityResumed(final Activity activity) {
        mCurrentResumedActivity = (AppCompatActivity) activity;
    }

    @Override
    public void onActivityPaused(final Activity activity) {
        mCurrentResumedActivity = null;
    }

    @Override
    public void onActivityStopped(final Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(final Activity activity, final Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(final Activity activity) {

    }

    public AppCompatActivity currentResumedActivity() {
        return mCurrentResumedActivity;
    }
}
