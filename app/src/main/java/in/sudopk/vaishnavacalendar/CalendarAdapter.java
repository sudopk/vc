package in.sudopk.vaishnavacalendar;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import in.sudopk.coreandroid.Layout;
import in.sudopk.coreandroid.SimpleList;
import in.sudopk.utils.StrUtil;
import in.sudopk.vaishnavacalendar.retrofit.VCalendar;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.VH> {
    private static final String TAG = "CalendarAdapter";

    private final List<DayCalendar> mCalendar;
    private final Gson mGson;
    private int mDateToHighlight;

    /**
     * @param dateToHighlight Month dates i.e. 1 to 31. Pass 0 if don't want to highlight any date
     */
    public CalendarAdapter(final Gson gson, int dateToHighlight) {
        mDateToHighlight = dateToHighlight;
        mCalendar = new ArrayList<>();
        mGson = gson;
    }

    @Override
    public VH onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final int cell, eventLayout;
        if(viewType ==0 ) {
            cell = R.layout.calendar_cell;
            eventLayout = R.layout.text_view;
        } else {
            cell = R.layout.calendar_cell_today;
            eventLayout = R.layout.text_view_inverse;
        }
        return new VH(LayoutInflater.from(parent.getContext())
                .inflate(cell, parent, false), eventLayout);
    }

    @Override
    public int getItemViewType(final int position) {
        if(mDateToHighlight- 1 == position) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        holder.onBind(mCalendar.get(position));
    }

    @Override
    public int getItemCount() {
        return mCalendar.size();
    }

    public void setData(final String data) {
        if (StrUtil.isNotEmpty(data)) {
            try {
                final VCalendar.Response calendarResponce =
                        mGson.fromJson(data, VCalendar.Response.class);
                setData(calendarResponce);
            } catch (JsonSyntaxException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void setData(final VCalendar.Response calendarResponce) {
        mCalendar.clear();
        final Map<Integer, List<String>> calendar = calendarResponce.getCalendar();
        for (Integer day : calendar.keySet()) {
            mCalendar.add(new DayCalendar(day, calendar.get(day)));
        }
        Collections.sort(mCalendar);
        notifyDataSetChanged();
    }

    static class VH extends RecyclerView.ViewHolder {
        private final SimpleList mEvents;
        private final int mEventLayout;
        private final TextView mDate;

        VH(final View itemView, @LayoutRes final int eventLayout) {
            super(itemView);
            mDate = Layout.findViewById(itemView, R.id.date);
            mEvents = Layout.findViewById(itemView, R.id.events);
            mEventLayout = eventLayout;
        }

        public void onBind(final DayCalendar dayCalendar) {
            mDate.setText(String.format(Locale.getDefault(), "%d", dayCalendar.getDate()));
            mEvents.setAdapter(new ArrayAdapter<>(itemView.getContext(),
                    mEventLayout, dayCalendar.getEvents()));
        }
    }
}
