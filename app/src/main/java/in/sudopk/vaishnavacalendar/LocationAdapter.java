package in.sudopk.vaishnavacalendar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import in.sudopk.coreandroid.Layout;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.VH> {
    private static final String TAG = "CalendarAdapter";

    private final List<Country> mCounteries;

    public LocationAdapter() {
        mCounteries = new ArrayList<>();
    }

    @Override
    public VH onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new VH(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_cell, parent, false));
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        holder.setCountry(mCounteries.get(position));
    }

    @Override
    public int getItemCount() {
        return mCounteries.size();
    }

    public void setData(final List<Country> data) {
        mCounteries.clear();
        mCounteries.addAll(data);
        Collections.sort(mCounteries);
        notifyDataSetChanged();
    }

    static class VH extends RecyclerView.ViewHolder {
        private final TextView mLocations;
        private final TextView mCountry;

        VH(final View itemView) {
            super(itemView);
            mCountry = Layout.findViewById(itemView, R.id.country);
            mLocations = Layout.findViewById(itemView, R.id.locations);
        }

        public void setCountry(final Country dayCalendar) {
            mCountry.setText(dayCalendar.getName());
            StringBuilder sb = new StringBuilder();
            for (Location location : dayCalendar.getLocations()) {
                sb.append(location.getName());
                sb.append("(");
                sb.append(location.getId());
                sb.append(")");
                sb.append("\n");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            mLocations.setText(sb.toString());
        }
    }
}
