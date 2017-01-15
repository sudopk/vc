package in.sudopk.vaishnavacalendar.retrofit;

import java.util.List;

import in.sudopk.vaishnavacalendar.Country;
import in.sudopk.vaishnavacalendar.VCalendar;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VcService {
    String URL =  "http://www.vaisnavacalendar.com/";

    @GET("vcal.php")
    @VcApi.Calendar
    Call<VCalendar> calendar(@Query("month") String month, @Query("year") int year,
                                       @Query("lang") String lang, @Query("CIID") String locationId);

    @GET("vcal.php")
    @VcApi.Locations
    Call<List<Country>> locations();
}
