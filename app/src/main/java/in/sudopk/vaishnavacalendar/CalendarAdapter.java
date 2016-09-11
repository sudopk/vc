package in.sudopk.vaishnavacalendar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import in.sudopk.coreandroid.Layout;
import in.sudopk.utils.StrUtil;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.VH> {
    private static final String TAG = "CalendarAdapter";

    private final List<DayCalendar> mCalendar;

    public CalendarAdapter() {
        mCalendar = new ArrayList<>();
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
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(data);
                jsonObject = jsonObject.getJSONObject("calendar");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jsonObject != null) {
                List<DayCalendar> days = new ArrayList<>();
                Iterator<String> it = jsonObject.keys();
                while (it.hasNext()) {
                    final String key = it.next();
                    Integer date = null;
                    try {
                        date = Integer.parseInt(key);
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }

                    if (date != null) {
                        JSONArray jsonArray = null;

                        try {
                            jsonArray = jsonObject.getJSONArray(key);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (jsonArray != null) {
                            ArrayList<String> events = new ArrayList<>();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                try {
                                    events.add(jsonArray.getString(i));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (!events.isEmpty()) {
                                days.add(new DayCalendar(date, events));
                            }
                        }
                    }
                }

                if (!days.isEmpty()) {
                    mCalendar.clear();
                    mCalendar.addAll(days);
                    Collections.sort(mCalendar);
                    notifyDataSetChanged();
                }
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
            mEvents.setText(dayCalendar.getEvents());
        }
    }
}
