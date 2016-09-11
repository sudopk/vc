package in.sudopk.vaishnavacalendar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import in.sudopk.DefaultHttpClient;
import in.sudopk.HttpClient;
import in.sudopk.coreandroid.Layout;

public class CalendarFragment extends Fragment {
    private CalendarAdapter mAdapter;
    private HttpClient mHttpClient;
    private Handler mHandler;
    private ProgressBar mProgressBar;
    private static final String CALENDAR_URL = "http://sudopkvc.appspot.com/calendar/";;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHttpClient = new DefaultHttpClient();
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.calendar, container, false);
        mProgressBar = Layout.findViewById(view, R.id.progressBar);
        final RecyclerView recyclerView = Layout.findViewById(view, R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new CalendarAdapter();
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    private void refresh() {
        if(isResumed()) {
            mProgressBar.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String response = mHttpClient.makeGetRequest(CALENDAR_URL);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            onCalendarResponse(response);
                        }
                    });
                }
            }).start();
        }
    }

    private void onCalendarResponse(final String response) {
        if (isResumed()) {
            mProgressBar.setVisibility(View.GONE);
            mAdapter.setData(response);
        }
    }
}
