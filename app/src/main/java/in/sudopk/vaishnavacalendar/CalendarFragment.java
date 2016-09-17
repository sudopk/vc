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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import in.sudopk.DefaultHttpClient;
import in.sudopk.HttpClient;
import in.sudopk.coreandroid.Layout;

public class CalendarFragment extends Fragment {
    private static final String CALENDAR_URL = "http://sudopkvc.appspot.com/calendar/";
    private static final String CALENDAR_DATA = "calendarData";
    private CalendarAdapter mAdapter;
    private HttpClient mHttpClient;
    private Handler mHandler;
    private ProgressBar mProgressBar;
    private String mCalendarData;
    private RecyclerView mRecyclerView;
    ;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHttpClient = new DefaultHttpClient();
        mHandler = new Handler(Looper.getMainLooper());
        if(savedInstanceState != null) {
            mCalendarData = savedInstanceState.getString(CALENDAR_DATA);
        }
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
    public void onResume() {
        super.onResume();
        if(TextUtils.isEmpty(mCalendarData)) {
            refresh();
        } else {
            onCalendarResponse(mCalendarData);
        }
    }

    private void refresh() {
        if (isResumed()) {
            mProgressBar.setVisibility(View.VISIBLE);
            new Thread(() -> {
                final Map<String, String> postData = new HashMap<>();
                postData.put("locationId", "395");
                final Calendar calendar = Calendar.getInstance();
                postData.put("month", Integer.toString(calendar.get(Calendar.MONTH)+1));
                postData.put("year", Integer.toString(calendar.get(Calendar.YEAR)));
                String response = mHttpClient.makePostRequest(CALENDAR_URL, postData);
                mHandler.post(() -> onCalendarResponse(response));
            }).start();
        }
    }

    private void onCalendarResponse(final String response) {
        if (isResumed()) {
            mCalendarData = response;
            mProgressBar.setVisibility(View.GONE);
            mAdapter.setData(response);
            mRecyclerView.getLayoutManager().scrollToPosition(Calendar.getInstance().get(Calendar.DATE)-1);
        }
    }
}
