package in.sudopk.vaishnavacalendar;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.design.widget.Snackbar;
import android.support.multidex.MultiDexApplication;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.sudopk.vaishnavacalendar.calendar.CalendarStore;
import in.sudopk.vaishnavacalendar.gson.RemoveFieldNameStrategy;
import in.sudopk.vaishnavacalendar.location.LocationStore;
import in.sudopk.vaishnavacalendar.retrofit.VcService;

public class VcApp extends MultiDexApplication {
    private Gson mGson;
    private LocationStore mLocationStore;
    private CalendarStore mCalendarStore;
    private VcService mVcService;
    private VcActivityLifecycleCallbacks mLifecycleCallbacks;

    @Override
    public void onCreate() {
        super.onCreate();
        mLifecycleCallbacks = new VcActivityLifecycleCallbacks();
        registerActivityLifecycleCallbacks(mLifecycleCallbacks);

        mGson = new GsonBuilder()
                .setFieldNamingStrategy(new RemoveFieldNameStrategy())
                .create();
        mVcService = VcService.newInstance();

        mCalendarStore = new CalendarStore(this, mGson);
        mLocationStore = new LocationStore(this, mGson);
    }

    public LocationStore getLocationStore() {
        return mLocationStore;
    }

    public Gson getGson() {
        return mGson;
    }

    public VcService getVcService() {
        return mVcService;
    }

    public CalendarStore getCalendarStore() {
        return mCalendarStore;
    }

    public void showBlockingNotification() {
        AppCompatActivity activity = currentActivity();
        final FragmentManager fm = activity.getSupportFragmentManager();
        final AppCompatDialogFragment dialogFragment = new AppCompatDialogFragment();
        dialogFragment.setCancelable(false);
        dialogFragment.show(fm, null);
    }

    public void showSoftNotification() {
        Activity activity = currentActivity();

        Snackbar snackbar = Snackbar.make(activity.getWindow().getDecorView(), "", Snackbar
                .LENGTH_SHORT);
        snackbar.show();
    }

    private AppCompatActivity currentActivity() {
        return mLifecycleCallbacks.currentResumedActivity();
    }

    public int versionCode() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
