package in.sudopk.vaishnavacalendar;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import in.sudopk.coreandroid.CalUtil;
import in.sudopk.coreandroid.Layout;
import in.sudopk.coreandroid.SimpleList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.VH> {
    private static final String TAG = "CalendarAdapter";

    private final List<DayCalendar> mVCalendar;
    private int mDateToHighlight;
    private int mMonth;
    private int mYear;


    /**
     * @param month 1 to 12
     * @param year Full year e.g. 2016
     */
    public CalendarAdapter(int month, int year) {
        mMonth = month;
        mYear = year;
        mVCalendar = new ArrayList<>();
    }

    /**
     * @param dateToHighlight Month dates i.e. 1 to 31. Pass 0 if don't want to highlight any date
     */
    public void setDateToHighlight(int dateToHighlight) {
        mDateToHighlight = dateToHighlight;
        notifyDataSetChanged();
    }

    @Override
    public VH onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final int cell, eventLayout;
        if (viewType == 0) {
            cell = R.layout.calendar_cell;
            eventLayout = R.layout.text_view;
        } else {
            cell = R.layout.calendar_cell_today;
            eventLayout = R.layout.text_view;
        }
        return new VH(LayoutInflater.from(parent.getContext())
                .inflate(cell, parent, false), eventLayout, mMonth, mYear);
    }

    @Override
    public int getItemViewType(final int position) {
        if (mDateToHighlight - 1 == position) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        holder.onBind(mVCalendar.get(position));
    }

    @Override
    public int getItemCount() {
        return mVCalendar.size();
    }

    public void setData(final VCalendar calendar) {
        mVCalendar.clear();
        mVCalendar.addAll(calendar.getCalendar());
        Collections.sort(mVCalendar);
        notifyDataSetChanged();
    }

    static class VH extends RecyclerView.ViewHolder {
        private final SimpleList mEvents;
        private final int mEventLayout;
        private final TextView mDate;
        private final Calendar mMonthCalendar;

        VH(final View itemView, @LayoutRes final int eventLayout, final int month, final int year) {
            super(itemView);
            mDate = Layout.findViewById(itemView, R.id.date);
            mEvents = Layout.findViewById(itemView, R.id.events);
            mEventLayout = eventLayout;

            mMonthCalendar = Calendar.getInstance();
            mMonthCalendar.set(Calendar.MONTH, month-1);
            mMonthCalendar.set(Calendar.YEAR, year);
        }

        public void onBind(final DayCalendar dayCalendar) {
            mMonthCalendar.set(Calendar.DATE, dayCalendar.getDate());
            mDate.setText(CalUtil.monthAbbreviation(mMonthCalendar) + " " + dayCalendar.getDate() + "\n" + CalUtil.weekDayAbbreviation(mMonthCalendar));
            mEvents.setAdapter(new ArrayAdapter<>(itemView.getContext(),
                    mEventLayout, dayCalendar.getEvents()));
        }
    }
}
