package byc.avt.avanteeborrower.helper.network;

import org.json.JSONObject;

import byc.avt.avanteeborrower.helper.constants.Constant;
import byc.avt.avanteeborrower.model.User;
import byc.avt.avanteeborrower.model.UserResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST(Constant.Endpoint.SIGN_IN)
    Call<JSONObject> login(
            @Field("email") String email,
            @Field("password") String password
    );

    @Headers({

    })
    @POST("auth/register")
    Call<User> register();
}