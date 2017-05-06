package in.sudopk.vaishnavacalendar;

import android.annotation.SuppressLint;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ViewAnimator;

import java.util.Calendar;

import in.sudopk.vaishnavacalendar.calendar.CalendarAdapter;
import in.sudopk.vaishnavacalendar.calendar.CalendarDelegate;
import in.sudopk.vaishnavacalendar.calendar.CalendarFragment;
import in.sudopk.vaishnavacalendar.calendar.CalendarStore;
import in.sudopk.vaishnavacalendar.location.Location;
import in.sudopk.vaishnavacalendar.retrofit.VcService;
import retrofit2.Call;
import retrofit2.Callback;

public class ResumedCalendar implements CalendarDelegate {
    private final CalendarStore mCalendarStore;
    private final int mMonth;
    private final int mYear;
    private final CalendarFragment.Container mContainer;
    private final ViewAnimator mViewAnimator;
    private final ProgressBar mProgressBar;
    private final VcService mVcService;
    private final Callback<VCalendar> mCalendarRequestCallback;
    private final CalendarAdapter mAdapter;
    private final RecyclerView mRecyclerView;

    public ResumedCalendar(final CalendarStore calendarStore, final int month, final int year,
                           final CalendarFragment.Container container, final ViewAnimator
                                   viewAnimator, final ProgressBar
                                   progressBar, final VcService vcService, final
                           Callback<VCalendar> calendarRequestCallback,
                           final CalendarAdapter adapter, final RecyclerView recyclerView) {
        mCalendarStore = calendarStore;
        mMonth = month;
        mYear = year;
        mContainer = container;
        mViewAnimator = viewAnimator;
        mProgressBar = progressBar;
        mVcService = vcService;
        mCalendarRequestCallback = calendarRequestCallback;
        mAdapter = adapter;
        mRecyclerView = recyclerView;
    }

    @Override
    public void onChangeLocationRequest() {
        mContainer.onChangeLocationRequest();
    }

    @Override
    public void onRefresh() {
        mCalendarStore.removeCalendar(mMonth, mYear);
        tryShowingCalendar();
    }

    @Override
    public void tryShowingCalendar() {
        mViewAnimator.setDisplayedChild(CalendarFragment.CALENDAR_VIEW_INDEX);
        mProgressBar.setVisibility(View.VISIBLE);

        if (mCalendarStore.hasCalendar(mMonth, mYear)) {
            onCalendarResponse(mCalendarStore.getCalendar(mMonth, mYear));
        } else {
            final Location location = mCalendarStore.getLocation();
            if (location == null) {
                onChangeLocationRequest();
            } else {
                @SuppressLint("DefaultLocale")  // The string formatted here is not for end user
                        Call<VCalendar> call = mVcService.calendar(String.format("%02d", mMonth),
                        mYear, "en", location.getId());
                call.enqueue(mCalendarRequestCallback);
            }
        }
    }

    @Override
    public void onCalendarRequestFailed() {
        mProgressBar.setVisibility(View.GONE);
        Snackbar.make(mRecyclerView, R.string.calender_failure, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onCalendarResponse(final VCalendar calendar) {
        if (calendar != null) {
            mCalendarStore.saveCalendar(mMonth, mYear, calendar);
            showCalendar(calendar);
        } else {
            onCalendarRequestFailed();
        }
    }

    private void showCalendar(final VCalendar vCalendar) {
        if (vCalendar.hasData()) {
            mProgressBar.setVisibility(View.GONE);
            mAdapter.setData(vCalendar);

            final Calendar calendar = Calendar.getInstance();
            final boolean currentMonth = (mMonth == calendar.get(Calendar.MONTH) + 1) &&
                    (mYear == calendar.get(Calendar.YEAR));
            if (currentMonth) {
                int positionToScrollTo = calendar.get(Calendar.DATE) - 1;   // -1 for 0-based index
                // scroll one before the date
                if (positionToScrollTo > 0) {
                    positionToScrollTo--;
                }
                mRecyclerView.getLayoutManager()
                        .scrollToPosition(positionToScrollTo);

                mAdapter.setDateToHighlight(calendar.get(Calendar.DATE));
            } else {
                mAdapter.setDateToHighlight(0);
            }
        } else {
            mViewAnimator.setDisplayedChild(CalendarFragment.NO_DATA_VIEW_INDEX);
        }
    }
}
