package in.sudopk.vaishnavacalendar.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface VcService {
    @POST("calendar")
    Call<VCalendar.Response> calendar(@Body VCalendar.Request user);
}
