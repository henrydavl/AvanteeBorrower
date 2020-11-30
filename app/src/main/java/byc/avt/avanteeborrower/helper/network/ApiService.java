package byc.avt.avanteeborrower.helper.network;

import com.google.gson.JsonObject;

import byc.avt.avanteeborrower.helper.constants.Constant;
import byc.avt.avanteeborrower.model.local.User;
import byc.avt.avanteeborrower.model.response.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @POST(Constant.Endpoint.SIGN_IN)
    Call<UserResponse> login(@Body JsonObject object);

    @POST(Constant.Endpoint.REGISTER)
    Call<User> register(@Body JsonObject object);
}