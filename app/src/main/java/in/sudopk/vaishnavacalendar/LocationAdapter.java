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
    private final static int HEADER_VIEW_TYPE = 0;
    private final static int CELL_VIEW_TYPE = 1;
    private final List<Country> mCounteries = new ArrayList<>();
    private final LocationContainer mContainer;
    private int[] mCountryIndex = new int[0];
    private int[] mCountryIndexCumulative = new int[0];


    public LocationAdapter(final LocationContainer container) {
        mContainer = container;
    }

    @Override
    public VH onCreateViewHolder(final ViewGroup parent, final int viewType) {
        if (viewType == HEADER_VIEW_TYPE) {
            return new VH(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.location_header_cell, parent, false), mContainer);
        } else {
            return new VH(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.location_cell, parent, false), mContainer);
        }
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        holder.setCountry(mCounteries.get(mCountryIndex[position]), mCountryIndexCumulative[position]);
    }

    @Override
    public int getItemCount() {
        return mCountryIndex.length;
    }

    @Override
    public int getItemViewType(final int position) {
        if (position == 0 || mCountryIndex[position] != mCountryIndex[position - 1]) {
            return HEADER_VIEW_TYPE;
        } else {
            return CELL_VIEW_TYPE;
        }
    }

    public void setData(final List<Country> data) {
        mCounteries.clear();
        mCounteries.addAll(data);
        Collections.sort(mCounteries);

        updateCountryIndices(mCounteries);

        notifyDataSetChanged();
    }

    private void updateCountryIndices(List<Country> countries) {
        int total = countries.size();
        for (Country country : countries) {
            total += country.getLocations().size();
        }
        mCountryIndex = new int[total];
        mCountryIndexCumulative = new int[total];
        int index = 0;
        int cumulativeIndex = 0;
        for (Country country : countries) {
            final int nextCumulativeIndex = cumulativeIndex + country.getLocations().size() + 1;
            for (int i = cumulativeIndex; i < nextCumulativeIndex; i++) {
                mCountryIndex[i] = index;
                mCountryIndexCumulative[i] = cumulativeIndex;
            }
            index++;
            cumulativeIndex = nextCumulativeIndex;
        }
    }

    static class VH extends RecyclerView.ViewHolder {
        private final TextView mTextView;
        private Location mLocation;

        VH(final View itemView, final LocationContainer container) {
            super(itemView);
            mTextView = Layout.findViewById(itemView, R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    if (getItemViewType() != HEADER_VIEW_TYPE) {
                        container.onLocationSelected(mLocation);
                    }
                }
            });
        }

        public void setCountry(final Country country, int countryIndex) {
            if (getItemViewType() == HEADER_VIEW_TYPE) {
                mTextView.setText(country.getName());
            } else {
                mLocation = country.getLocations().get(getAdapterPosition() - countryIndex - 1);
                mTextView.setText(mLocation.getName());
            }
        }
    }
}
