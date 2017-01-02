package in.sudopk.vaishnavacalendar;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import in.sudopk.coreandroid.Fm;

public class MainActivity extends AppCompatActivity implements CalendarPagerFragment.Container, LocationContainer {

    private CalendarStore mCalendarStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

        mCalendarStore = ((VcApp) getApplication()).getCalendarStore();

        if (savedInstanceState == null) {
            launchCalendarPagerFragment();
        }
    }

    private void launchCalendarPagerFragment() {
        Fm.replace(getSupportFragmentManager(), R.id.container, new CalendarPagerFragment());
    }

    @Override
    public void onChangeLocationRequest() {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            // throws IllegalStateException, for reason which is not clear to me
            fragmentManager.executePendingTransactions();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }
        DialogFragment fragment = (DialogFragment) fragmentManager.findFragmentByTag(LocationFragment.TAG);
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
