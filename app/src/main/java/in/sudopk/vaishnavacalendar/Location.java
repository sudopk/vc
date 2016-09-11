package in.sudopk.vaishnavacalendar;

public class Location {
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
}
