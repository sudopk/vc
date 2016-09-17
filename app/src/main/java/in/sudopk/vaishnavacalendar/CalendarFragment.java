package in.sudopk.vaishnavacalendar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import in.sudopk.DefaultHttpClient;
import in.sudopk.HttpClient;
import in.sudopk.coreandroid.Layout;

public class CalendarFragment extends Fragment {
    private static final String CALENDAR_URL = "http://sudopkvc.appspot.com/calendar/";
    private CalendarAdapter mAdapter;
    private HttpClient mHttpClient;
    private Handler mHandler;
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private State mState;
    ;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHttpClient = new DefaultHttpClient();
        mHandler = new Handler(Looper.getMainLooper());
        mState = State.from(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.calendar, container, false);
        mProgressBar = Layout.findViewById(view, R.id.progressBar);
        mRecyclerView = Layout.findViewById(view, R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new CalendarAdapter();
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
            new Thread(() -> {
                final Map<String, String> postData = new HashMap<>();
                postData.put("locationId", "395");
                final Calendar calendar = Calendar.getInstance();
                postData.put("month", Integer.toString(calendar.get(Calendar.MONTH) + 1));
                postData.put("year", Integer.toString(calendar.get(Calendar.YEAR)));
                String response = mHttpClient.makePostRequest(CALENDAR_URL, postData);
                mHandler.post(() -> {
                    mState = new State(response);
                    onCalendarResponse(response);
                });
            }).start();
        }
    }

    private void onCalendarResponse(final String response) {
        if (isResumed()) {
            mProgressBar.setVisibility(View.GONE);
            mAdapter.setData(response);
            mRecyclerView.getLayoutManager().scrollToPosition(Calendar.getInstance().get(Calendar.DATE) - 1);
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
