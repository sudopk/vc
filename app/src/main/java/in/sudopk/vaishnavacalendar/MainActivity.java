package in.sudopk.vaishnavacalendar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import in.sudopk.coreandroid.Fm;
import in.sudopk.vaishnavacalendar.calendar.CalendarPagerFragment;
import in.sudopk.vaishnavacalendar.calendar.CalendarStore;
import in.sudopk.vaishnavacalendar.location.Location;
import in.sudopk.vaishnavacalendar.location.LocationContainer;
import in.sudopk.vaishnavacalendar.location.LocationFragment;
import in.sudopk.vaishnavacalendar.retrofit.VcConfigService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CalendarPagerFragment.Container,
        LocationContainer, TextDialog.Container {

    private static final String EXIT_BUTTON_ID = "cancel";
    private static final String UPDATE_BUTTON_ID = "ok";
    private CalendarStore mCalendarStore;
    private boolean mResumed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

        mCalendarStore = ((VcApp) getApplication()).getCalendarStore();

        if (savedInstanceState == null) {
            launchCalendarPagerFragment();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mResumed = true;
        checkForVersion();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mResumed = false;
    }

    /**
     * Do not name this method 'isResumed', there would be a crash.
     * Actually isResumed() is already a method in some super class but is hidden (@hide)
     * Crash:
     * Theme: themes:{default=overlay:system, iconPack:system, fontPkg:system, com.android.systemui=overlay:system, com.android.systemui.navbar=overlay:system}
     java.lang.LinkageError
     * http://stackoverflow.com/questions/34061704/java-lang-linkageerror-mainactivity
     */
    protected final boolean isActivityResumed() {
        return mResumed;
    }

    private void showTooOldAppDialog() {
        if (isActivityResumed()) {
            final String tag = "BlockingDialog";
            if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
//            TODO use res
                TextDialog dialog = TextDialog.Companion.newBlockingInstance("This version of the app is " +
                                "too old and must be updated.",
                        new ButtonDescription[]{
                                new ButtonDescription("Exit", EXIT_BUTTON_ID),
                                new ButtonDescription("Update", UPDATE_BUTTON_ID),
                        });
                dialog.show(getSupportFragmentManager(), tag);
            }
        }
    }

    @Override
    public void onDialogButtonClicked(final String buttonId) {
        switch (buttonId) {
            case UPDATE_BUTTON_ID:
                goToPlayStore();
                break;
            case EXIT_BUTTON_ID:
                onDialogCanceled();
                break;
            default:
                break;
        }
    }

    private void goToPlayStore() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.waze"));
        startActivity(intent);
    }

    @Override
    public void onDialogCanceled() {
        onBackPressed();
    }


    private void checkForVersion() {
        final Call<VcConfig> config = VcConfigService.Companion.newInstance(((VcApp) getApplication())
                .getGson()).config();
        config.enqueue(new Callback<VcConfig>() {
            @Override
            public void onResponse(final Call<VcConfig> call, final Response<VcConfig> response) {
                final VcConfig config = response.body();
                final VcApp vcApp = (VcApp) getApplication();
                if (vcApp.versionCode() < config.getVersion().getHard()) {
                    showTooOldAppDialog();
                } else if (vcApp.versionCode() < config.getVersion().getSoft()) {
                    showRecommendedUpdate();
                }
            }

            @Override
            public void onFailure(final Call<VcConfig> call, final Throwable t) {
                // no-op
            }
        });
    }

    private void showRecommendedUpdate() {
        if (isActivityResumed()) {
            final Snackbar snackbar = Snackbar.make(findViewById(R.id.container), "App seems old." +
                            " Recommended to update.",
                    Snackbar.LENGTH_LONG);
            snackbar.setAction("UPDATE", v -> {
                goToPlayStore();
            });
            snackbar.show();
        }
    }

    private void launchCalendarPagerFragment() {
        Fm.replace(getSupportFragmentManager(), R.id.container, new CalendarPagerFragment());
    }

    @Override
    public void onChangeLocationRequest() {
        // TODO handle when there is blocking update
        final FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            // throws IllegalStateException, for reason which is not clear to me
            fragmentManager.executePendingTransactions();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }
        DialogFragment fragment = (DialogFragment) fragmentManager.findFragmentByTag
                (LocationFragment.TAG);
        if (fragment == null) {
            fragment = LocationFragment.newInstance();
            fragment.show(fragmentManager, LocationFragment.TAG);
        }
    }

    @Override
    public void onLocationSelected(Location location) {
        mCalendarStore.setLocation(location);
        launchCalendarPagerFragment();
    }

    @Override
    public void onLocationSelectCanceled() {
        if (mCalendarStore.getLocation() == null) {
            Toast.makeText(this, R.string.location_required, Toast.LENGTH_LONG).show();
            onChangeLocationRequest();
        }
    }
}
