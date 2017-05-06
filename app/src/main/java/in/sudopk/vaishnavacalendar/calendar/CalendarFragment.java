package in.sudopk.vaishnavacalendar.calendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import android.widget.ViewAnimator;

import in.sudopk.coreandroid.Fm;
import in.sudopk.coreandroid.Layout;
import in.sudopk.vaishnavacalendar.NoActionCalendar;
import in.sudopk.vaishnavacalendar.R;
import in.sudopk.vaishnavacalendar.ResumedCalendar;
import in.sudopk.vaishnavacalendar.VCalendar;
import in.sudopk.vaishnavacalendar.VcApp;
import in.sudopk.vaishnavacalendar.retrofit.VcService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalendarFragment extends Fragment implements Callback<VCalendar> {
    public static final int CALENDAR_VIEW_INDEX = 0;
    public static final int NO_DATA_VIEW_INDEX = 1;
    private static final String MONTH = "month";
    private static final String YEAR = "year";
    private CalendarDelegate mDelegate, mResumed, mNoAction;

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
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        final VcService vcService = ((VcApp) getActivity().getApplication()).getVcService();
        final CalendarStore calendarStore = ((VcApp) getActivity().getApplication())
                .getCalendarStore();

        final int year = getArguments().getInt(YEAR);
        final int month = getArguments().getInt(MONTH);

        final View view = inflater.inflate(R.layout.calendar, container, false);
        final ViewAnimator viewAnimator = Layout.findViewById(view, R.id.viewAnimator);
        final ProgressBar progressBar = Layout.findViewById(view, R.id.progressBar);
        final RecyclerView recyclerView = Layout.findViewById(view, R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final CalendarAdapter adapter = new CalendarAdapter(month, year);
        recyclerView.setAdapter(adapter);


        mDelegate = mNoAction = new NoActionCalendar();
        mResumed = new ResumedCalendar(calendarStore, month, year, (Container) Fm.container(this)
                , viewAnimator, progressBar, vcService, this, adapter, recyclerView);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater) {
        inflater.inflate(R.menu.calendar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            mDelegate.onRefresh();
        } else if (item.getItemId() == R.id.location) {
            mDelegate.onChangeLocationRequest();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        mDelegate = mResumed;
        mDelegate.tryShowingCalendar();
    }

    @Override
    public void onPause() {
        super.onPause();
        mDelegate = mNoAction;
    }

    @Override
    public void onResponse(final Call<VCalendar> call, final Response<VCalendar> response) {
        mDelegate.onCalendarResponse(response.body());
    }

    @Override
    public void onFailure(final Call<VCalendar> call, final Throwable t) {
        t.printStackTrace();
        mDelegate.onCalendarRequestFailed();
    }

    public interface Container {
        void onChangeLocationRequest();
    }
}
