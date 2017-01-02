package in.sudopk.vaishnavacalendar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import in.sudopk.coreandroid.Fm;
import in.sudopk.coreandroid.Layout;
import in.sudopk.vaishnavacalendar.retrofit.VcService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationFragment extends AppCompatDialogFragment implements LocationContainer {
    public static final String TAG = LocationFragment.class.getName();
    private LocationAdapter mAdapter;
    private ProgressBar mProgressBar;
    private VcService mVcService;
    private LocationStore mLocationStore;
    private CalendarStore mCalendarStore;
    private RecyclerView mRecyclerView;

    public static DialogFragment newInstance() {
        return new LocationFragment();
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setHasOptionsMenu(true);

        mVcService = ((VcApp) getActivity().getApplication()).getVcService();

        mLocationStore = ((VcApp) getActivity().getApplication()).getLocationStore();
        mCalendarStore = ((VcApp) getActivity().getApplication()).getCalendarStore();

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle(R.string.location_title);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.location, container, false);
        mProgressBar = Layout.findViewById(view, R.id.progressBar);
        mRecyclerView = Layout.findViewById(view, R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new LocationAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater) {
        inflater.inflate(R.menu.calendar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            refresh();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    public void onCancel(final DialogInterface dialog) {
        super.onCancel(dialog);
        getContainer().onLocationSelectCanceled();
    }

    @Override
    public void onLocationSelected(final Location location) {
        dismiss();
        getContainer().onLocationSelected(location);
    }

    @Override
    public void onLocationSelectCanceled() {
        dismiss();
        getContainer().onLocationSelectCanceled();
    }

    private LocationContainer getContainer() {
        return Fm.container(this);
    }

    private void refresh() {
        if (isResumed()) {
            mProgressBar.setVisibility(View.VISIBLE);

            if (mLocationStore.hasLocations()) {
                onLocationResponse(mLocationStore.getLocations());
            } else {
                Call<List<Country>> locationsCall = mVcService.locations();
                locationsCall.enqueue(new Callback<List<Country>>() {
                    @Override
                    public void onResponse(final Call<List<Country>> call, final Response<List<Country>> response) {
                        if (isResumed()) {
                            if (response.body() != null) {
                                mLocationStore.saveLocations(response.body());
                                onLocationResponse(mLocationStore.getLocations());
                            } else {
                                failed();
                            }
                        }
                    }

                    @Override
                    public void onFailure(final Call<List<Country>> call, final Throwable t) {
                        t.printStackTrace();
                        failed();
                    }
                });
            }
        }
    }

    private void failed() {
        if (isResumed()) {
            mProgressBar.setVisibility(View.GONE);
            if (getView() != null) {
                Snackbar.make(getView(), R.string.locations_failure, Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    private void onLocationResponse(final List<Country> response) {
        if (isResumed()) {
            mProgressBar.setVisibility(View.GONE);
            mAdapter.setData(response);

            int position = mAdapter.getPosition(mCalendarStore.getLocation());
            if (position > 0) {
                // lets scroll to location one before the actual one, looks little better
                position--;
            }
            mRecyclerView.getLayoutManager()
                    .scrollToPosition(position);
        }
    }

}
