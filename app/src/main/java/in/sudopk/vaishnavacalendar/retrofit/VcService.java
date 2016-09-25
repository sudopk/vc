package in.sudopk.vaishnavacalendar.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface VcService {
    @POST("calendar")
    Call<VCalendar.Response> calendar(@Body VCalendar.Request user);
    @GET("calendar.json")
    Call<VCalendar.Response> calendar();
    @GET("locations.json")
    Call<VCalendar.Response> locations();
}
