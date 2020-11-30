package byc.avt.avanteeborrower.helper.network;

import android.util.Log;

import com.google.gson.JsonObject;

import byc.avt.avanteeborrower.helper.constants.Constant;
import byc.avt.avanteeborrower.model.response.UserResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private ApiService apiService;
    private static RetrofitService service;
    private static final String TAG = "RetrofitService";

    private RetrofitService() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(chain -> {
            Log.d(TAG, "RetrofitService: " + Constant.BaseSetting.BASIC_AUTH);
            Request request = chain.request().newBuilder()
                    .addHeader(
                            "Authorization", Constant.BaseSetting.BASIC_AUTH)
                    .build();
            return chain.proceed(request);
        });

        httpClient.addInterceptor(logging);

        apiService = new Retrofit.Builder()
                .baseUrl(Constant.BaseSetting.BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
    }

    public static RetrofitService getInstance() {
        if (service == null) {
            service = new RetrofitService();
        }
        return service;
    }

    public Call<UserResponse> login(JsonObject loginInfo) {
        return apiService.login(loginInfo);
    }
}
