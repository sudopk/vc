package in.sudopk.vaishnavacalendar;

import android.support.annotation.NonNull;

public class Location implements Comparable<Location> {
    private String mName;
    private String mId;

    public Location(final String name, final String id) {
        mName = name;
        mId = id;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    @Override
    public int compareTo(@NonNull final Location o) {
        return getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(final Object obj) {
        return (obj instanceof Location) && compareTo((Location) obj) == 0;
    }
}
