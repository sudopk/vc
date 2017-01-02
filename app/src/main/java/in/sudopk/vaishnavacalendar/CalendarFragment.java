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
    private State mState;
    private VcService mVcService;
    private Gson mGson;
    private int mMonth;
    private int mYear;
    private boolean mCurrentMonth;
    private int mTodayDate;
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
        mState = State.from(savedInstanceState);
        setHasOptionsMenu(true);
        mGson = ((VcApp) getActivity().getApplication()).getGson();
        mVcService = ((VcApp) getActivity().getApplication()).getVcService();
        mCalendarStore = ((VcApp) getActivity().getApplication()).getCalendarStore();

        mMonth = getArguments().getInt(MONTH);
        mYear = getArguments().getInt(YEAR);
        final Calendar calendar = Calendar.getInstance();
        mTodayDate = calendar.get(Calendar.DATE);
        mCurrentMonth = (mMonth == calendar.get(Calendar.MONTH) + 1) &&
                (mYear == calendar.get(Calendar.YEAR));
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
        final int dateToHighlight =
                mCurrentMonth ? mTodayDate : 0;
        mAdapter = new CalendarAdapter(mGson, dateToHighlight);
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

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        mState.saveTo(outState);
    }

    public void refresh() {
        if (isResumed()) {
            mProgressBar.setVisibility(View.VISIBLE);

            if (mCalendarStore.hasCalendar(mMonth, mYear)) {
                onCalendarResponse(mCalendarStore.getCalendar(mMonth, mYear));
            } else {
                final Location location = mCalendarStore.getLocation();
                if(location == null) {
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

    private void onCalendarResponse(final VCalendar calendar) {
        if (isResumed()) {
            mProgressBar.setVisibility(View.GONE);
            mAdapter.setData(calendar);
            if (mCurrentMonth) {
                mRecyclerView.getLayoutManager()
                        .scrollToPosition(Calendar.getInstance().get(Calendar.DATE) - 1);
            }
        }
    }

    public Container getContainer() {
        return Fm.container(this);
    }

    public interface Container {
        void onChangeLocationRequest();
    }

    private static class State {
        private static final String CALENDAR_DATA = "calendarData";
        private static final String CALENDAR_DATE = "calendarDate";

        public final String calendarData;
        private long mCalendarDate;

        public State(final String calendarData) {
            this.calendarData = calendarData;
            mCalendarDate = Calendar.getInstance().getTimeInMillis();
        }

        public static State from(Bundle bundle) {
            if (bundle != null) {
                long date = bundle.getLong(CALENDAR_DATE, 0);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(date);
                if (isToday(calendar)) {
                    return new State(bundle.getString(CALENDAR_DATA, ""));
                }
            }
            return new State("");
        }

        private static boolean isToday(final Calendar calendar) {
            final Calendar today = Calendar.getInstance();
            return today.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) &&
                    today.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                    today.get(Calendar.DATE) == calendar.get(Calendar.DATE);
        }

        public void saveTo(Bundle bundle) {
            if (bundle != null) {
                bundle.putString(CALENDAR_DATA, calendarData);
                bundle.putLong(CALENDAR_DATE, mCalendarDate);
            }
        }
    }
}
