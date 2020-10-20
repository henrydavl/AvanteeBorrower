package byc.avt.avanteeborrower.helper.network;

import byc.avt.avanteeborrower.model.User;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @Headers({

    })
    @POST("login")
    Call<User> login();

    @Headers({

    })
    @POST("auth/register")
    Call<User> register();
}