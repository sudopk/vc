package in.sudopk.vaishnavacalendar.calendar;

import android.support.annotation.NonNull;

import java.util.List;

import in.sudopk.vaishnavacalendar.location.Location;

public class Country implements Comparable<Country> {
    private final String mName;
    private final List<Location> mLocations;

    public Country(final String name, final List<Location> locations) {
        mName = name;
        mLocations = locations;
    }

    public List<Location> getLocations() {
        return mLocations;
    }

    public String getName() {
        return mName;
    }

    @Override
    public int compareTo(@NonNull final Country country) {
        return mName.compareTo(country.getName());
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Country &&
                compareTo((Country) obj) == 0;
    }
}
