package in.sudopk.vaishnavacalendar;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class LocationStore {
    private static final String LOCATIONS = "locations";
    private final SharedPreferences mPreferences;
    private final Gson mGson;
    private List<Country> mLocations;

    public LocationStore(final Context context, final Gson gson) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mGson = gson;

        final String savedLocations = mPreferences.getString(LOCATIONS, "");
        if (savedLocations.isEmpty()) {
            mLocations = new ArrayList<>();
        } else {
            mLocations = mGson.fromJson(savedLocations, new TypeToken<List<Country>>() {
            }.getType());
        }
    }

    public List<Country> getLocations() {
        return mLocations;
    }

    public void saveLocations(List<Country> locations) {
        mLocations = locations;
        mPreferences.edit()
                .putString(LOCATIONS, mGson.toJson(locations))
                .apply();
    }

    public boolean hasLocations() {
        return !mLocations.isEmpty();
    }
}
