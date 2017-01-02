package in.sudopk.vaishnavacalendar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.util.Calendar;

import in.sudopk.coreandroid.Fm;
import in.sudopk.coreandroid.Layout;
import in.sudopk.vaishnavacalendar.retrofit.VcService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalendarFragment extends Fragment {
    private static final String MONTH = "month";
    private static final String YEAR = "year";

    private CalendarAdapter mAdapter;
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private VcService mVcService;
    private int mMonth;
    private int mYear;
    private CalendarStore mCalendarStore;

    /**
     * @param month 1 to 12
     * @param year  full year e.g. 2016
     */
    public static Fragment newInstance(final int month, final int year) {
        final Fragment fragment = new CalendarFragment();
        final Bundle bundle = new Bundle();
        bundle.putInt(MONTH, month);
        bundle.putInt(YEAR, year);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mVcService = ((VcApp) getActivity().getApplication()).getVcService();
        mCalendarStore = ((VcApp) getActivity().getApplication()).getCalendarStore();

        mMonth = getArguments().getInt(MONTH);
        mYear = getArguments().getInt(YEAR);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.calendar, container, false);
        mProgressBar = Layout.findViewById(view, R.id.progressBar);
        mRecyclerView = Layout.findViewById(view, R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new CalendarAdapter(mMonth, mYear);
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
            mCalendarStore.removeCalendar(mMonth, mYear);
            refresh();
        } else if (item.getItemId() == R.id.location) {
            getContainer().onChangeLocationRequest();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    public void refresh() {
        if (isResumed()) {
            mProgressBar.setVisibility(View.VISIBLE);

            if (mCalendarStore.hasCalendar(mMonth, mYear)) {
                onCalendarResponse(mCalendarStore.getCalendar(mMonth, mYear));
            } else {
                final Location location = mCalendarStore.getLocation();
                if (location == null) {
                    getContainer().onChangeLocationRequest();
                } else {
                    @SuppressLint("DefaultLocale")  // The string formatted here is not for end user
                            Call<VCalendar> call = mVcService.calendar(String.format("%02d", mMonth), mYear, "en", location.getId());
                    call.enqueue(new Callback<VCalendar>() {
                        @Override
                        public void onResponse(final Call<VCalendar> call,
                                               final Response<VCalendar> response) {
                            if (isResumed()) {
                                if (response.body() != null) {
                                    mCalendarStore.saveCalendar(mMonth, mYear, response.body());
                                    onCalendarResponse(response.body());
                                } else {
                                    failed();
                                }
                            }
                        }

                        @Override
                        public void onFailure(final Call<VCalendar> call, final Throwable t) {
                            t.printStackTrace();
                            failed();
                        }
                    });
                }
            }
        }
    }

    private void failed() {
        if (isResumed()) {
            mProgressBar.setVisibility(View.GONE);
            if (getView() != null) {
                Snackbar.make(getView(), R.string.calender_failure, Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    private void onCalendarResponse(final VCalendar vCalendar) {
        if (isResumed()) {
            mProgressBar.setVisibility(View.GONE);
            mAdapter.setData(vCalendar);

            final Calendar calendar = Calendar.getInstance();
            final boolean currentMonth = (mMonth == calendar.get(Calendar.MONTH) + 1) &&
                    (mYear == calendar.get(Calendar.YEAR));
            if (currentMonth) {
                mRecyclerView.getLayoutManager()
                        .scrollToPosition(calendar.get(Calendar.DATE) - 1);

                mAdapter.setDateToHighlight(calendar.get(Calendar.DATE));
            } else {
                mAdapter.setDateToHighlight(0);
            }
        }
    }

    public Container getContainer() {
        return Fm.container(this);
    }

    public interface Container {
        void onChangeLocationRequest();
    }
}
