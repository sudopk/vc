package in.sudopk.vaishnavacalendar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import in.sudopk.coreandroid.Layout;
import in.sudopk.utils.StrUtil;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.VH> {
    private static final String TAG = "CalendarAdapter";

    private final List<DayCalendar> mCalendar;
    private final Gson mGson;

    public CalendarAdapter() {
        mCalendar = new ArrayList<>();
        mGson = new GsonBuilder()
                .setFieldNamingStrategy(new RemoveFieldNameStrategy())
                .create();
    }

    @Override
    public VH onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new VH(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.calendar_cell, parent, false));
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        holder.setDayCalendar(mCalendar.get(position));
    }

    @Override
    public int getItemCount() {
        return mCalendar.size();
    }

    public void setData(final String data) {
        if (StrUtil.isNotEmpty(data)) {
            try {
                final CalendarResponce calendarResponce = mGson.fromJson(data, CalendarResponce.class);
                mCalendar.clear();
                final Map<Integer, List<String>> calendar = calendarResponce.getCalendar();
                for (Integer day : calendar.keySet()) {
                    mCalendar.add(new DayCalendar(day, calendar.get(day)));
                }
                Collections.sort(mCalendar);
                notifyDataSetChanged();
            } catch (JsonSyntaxException ex) {
                ex.printStackTrace();
            }
        }
    }

    static class VH extends RecyclerView.ViewHolder {
        private final TextView mEvents;
        private final TextView mDate;

        VH(final View itemView) {
            super(itemView);
            mDate = Layout.findViewById(itemView, R.id.date);
            mEvents = Layout.findViewById(itemView, R.id.events);
        }

        public void setDayCalendar(final DayCalendar dayCalendar) {
            mDate.setText(String.format(Locale.getDefault(), "%d", dayCalendar.getDate()));
            StringBuilder sb = new StringBuilder();

            final List<String> events = dayCalendar.getEvents();
            for (String event: events) {
                sb.append(event);
                sb.append("\n");
            }
            if(sb.length() > 0) {
                sb.setLength(sb.length()-1);
            }
            mEvents.setText(sb.toString());
        }
    }
}
