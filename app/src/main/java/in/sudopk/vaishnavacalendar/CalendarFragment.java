package in.sudopk.vaishnavacalendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;

import in.sudopk.coreandroid.Layout;
import in.sudopk.vaishnavacalendar.retrofit.VCalendar;
import in.sudopk.vaishnavacalendar.retrofit.VcService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CalendarFragment extends Fragment {
    private CalendarAdapter mAdapter;
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private State mState;
    private VcService mVcService;
    private Gson mGson;
    ;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mState = State.from(savedInstanceState);
        setHasOptionsMenu(true);
        mGson = new GsonBuilder()
                .setFieldNamingStrategy(new RemoveFieldNameStrategy())
                .create();
        mVcService = new Retrofit.Builder()
                .baseUrl(VcService.URL)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .build()
                .create(VcService.class);
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
        mAdapter = new CalendarAdapter(mGson);
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
            mState = State.from(null);
            refresh();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(mState.calendarData)) {
            refresh();
        } else {
            onCalendarResponse(mState.calendarData);
        }
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        mState.saveTo(outState);
    }

    private void refresh() {
        if (isResumed()) {
            mProgressBar.setVisibility(View.VISIBLE);
            Call<VCalendar.Response> call = mVcService.calendar();
            call.enqueue(new Callback<VCalendar.Response>() {
                @Override
                public void onResponse(final Call<VCalendar.Response> call,
                                       final Response<VCalendar.Response> response) {
                    if(isResumed()) {
                        if(response.body() != null) {
                            mState = new State(mGson.toJson(response.body()));
                            onCalendarResponse(mState.calendarData);
                        } else {
                            failed();
                        }
                    }
                }

                @Override
                public void onFailure(final Call<VCalendar.Response> call, final Throwable t) {
                    failed();
                }
            });
        }
    }

    private void failed() {
        if(isResumed()) {
            mProgressBar.setVisibility(View.GONE);
            if(getView() != null) {
                Snackbar.make(getView(), "Failed to fetch calendar.", Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    private void onCalendarResponse(final String response) {
        if (isResumed()) {
            mProgressBar.setVisibility(View.GONE);
            mAdapter.setData(response);
            mRecyclerView.getLayoutManager()
                    .scrollToPosition(Calendar.getInstance().get(Calendar.DATE) - 1);
        }
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
