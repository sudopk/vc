package in.sudopk.vaishnavacalendar.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface VcService {
    //String URL = "http://sudopk.github.io/vc/";

    /*@POST("calendar")
    Call<VCalendar.Response> calendar(@Body VCalendar.Request user);
    @GET("calendar.json")
    Call<VCalendar.Response> calendar();
    @GET("locations.json")
    Call<VCalendar.Response> locations();*/

    String URL =  "http://www.vaisnavacalendar.com/";

    @GET("vcal.php")
    Call<VCalendar.Response> calendar(@Query("month") String month, @Query("year") int year,
                                @Query("lang") String lang, @Query("CIID") String locationId);
}
