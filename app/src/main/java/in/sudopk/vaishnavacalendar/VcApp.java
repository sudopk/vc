package in.sudopk.vaishnavacalendar;

import android.support.multidex.MultiDexApplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.sudopk.vaishnavacalendar.retrofit.VcConverterFactory;
import in.sudopk.vaishnavacalendar.retrofit.VcService;
import retrofit2.Retrofit;

public class VcApp extends MultiDexApplication {
    private Gson mGson;
    private LocationStore mLocationStore;
    private CalendarStore mCalendarStore;
    private VcService mVcService;

    @Override
    public void onCreate() {
        super.onCreate();
        mGson = new GsonBuilder()
                .setFieldNamingStrategy(new RemoveFieldNameStrategy())
                .create();
        mVcService = new Retrofit.Builder()
                .baseUrl(VcService.URL)
                .addConverterFactory(new VcConverterFactory())
                .build()
                .create(VcService.class);

        mCalendarStore = new CalendarStore(this, mGson);
        mLocationStore = new LocationStore(this, mGson);
    }

    public LocationStore getLocationStore() {
        return mLocationStore;
    }

    public Gson getGson() {
        return mGson;
    }

    public VcService getVcService() {
        return mVcService;
    }

    public CalendarStore getCalendarStore() {
        return mCalendarStore;
    }
}
