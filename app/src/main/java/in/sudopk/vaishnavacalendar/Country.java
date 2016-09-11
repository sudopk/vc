package in.sudopk.vaishnavacalendar;

import java.util.ArrayList;
import java.util.List;

public class Country implements Comparable<Country> {
    private final String mName;
    private final List<Location> mLocations;

    public Country(final String name, final ArrayList<Location> locations) {
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
    public int compareTo(final Country country) {
        return mName.compareTo(country.getName());
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Country &&
                compareTo((Country) obj) == 0;
    }
}
