package in.sudopk.vaishnavacalendar.retrofit;

import in.sudopk.vaishnavacalendar.VcConfig;
import retrofit2.Call;
import retrofit2.http.GET;

public interface VcConfigService {
    String URL = "http://sudopk.github.io/vc/";

    @GET(value = "config.json")
    Call<VcConfig> config();
}
