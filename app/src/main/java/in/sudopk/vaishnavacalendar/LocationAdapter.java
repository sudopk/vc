package in.sudopk.vaishnavacalendar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import in.sudopk.coreandroid.Layout;
import in.sudopk.utils.StrUtil;

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

    public void setData(final String data) {
        if (StrUtil.isNotEmpty(data)) {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(data);
                jsonObject = jsonObject.getJSONObject("locations");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jsonObject != null) {
                List<Country> countries = new ArrayList<>();
                Iterator<String> it = jsonObject.keys();
                while (it.hasNext()) {
                    final String countryKey = it.next();

                    if (countryKey != null) {
                        ArrayList<Location> locations = new ArrayList<>();

                        JSONObject locationsObject = null;
                        try {
                            locationsObject = jsonObject.getJSONObject(countryKey);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (locationsObject != null) {
                            Iterator<String> it2 = locationsObject.keys();
                            while (it2.hasNext()) {
                                final String locationKey = it2.next();

                                if (locationKey != null) {
                                    try {
                                        locations.add(new Location(locationKey, locationsObject.getString(locationKey)));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        countries.add(new Country(countryKey, locations));
                    }
                }

                if (!countries.isEmpty()) {
                    mCounteries.clear();
                    mCounteries.addAll(countries);
                    Collections.sort(mCounteries);
                    notifyDataSetChanged();
                }
            }
        }
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
            for (Location location: dayCalendar.getLocations()) {
                sb.append(location.getName());
                sb.append("(");
                sb.append(location.getId());
                sb.append(")");
                sb.append("\n");
            }
            if(sb.length() > 0 ) {
                sb.setLength(sb.length() - 1);
            }
            mLocations.setText(sb.toString());
        }
    }
}
