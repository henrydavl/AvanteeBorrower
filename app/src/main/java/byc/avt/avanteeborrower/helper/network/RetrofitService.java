package byc.avt.avanteeborrower.helper.network;

import byc.avt.avanteeborrower.helper.constants.Constant;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private ApiService apiService;

    public RetrofitService() {
        apiService = new Retrofit.Builder()
                .baseUrl(Constant.BaseSetting.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
    }


}
