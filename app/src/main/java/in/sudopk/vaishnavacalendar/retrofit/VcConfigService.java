package in.sudopk.vaishnavacalendar.retrofit;

import com.google.gson.Gson;

import in.sudopk.vaishnavacalendar.VcConfig;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface VcConfigService {
    String URL = "http://sudopk.github.io/vc/";

    @GET(value = "config.json")
    Call<VcConfig> config();

    class Factory {

        public static VcConfigService newInstance(Gson gson) {
            return new Retrofit.Builder()
                    .baseUrl(VcConfigService.URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(VcConfigService.class);
        }
    }
}
