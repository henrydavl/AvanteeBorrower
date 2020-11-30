package byc.avt.avanteeborrower.view.auth;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import byc.avt.avanteeborrower.helper.network.RetrofitService;
import byc.avt.avanteeborrower.model.local.User;
import byc.avt.avanteeborrower.model.response.UserResponse;
import byc.avt.avanteeborrower.model.response.UserSession;
import cz.msebera.android.httpclient.Header;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static byc.avt.avanteeborrower.helper.constants.Constant.*;

public class AuthRepository {
    private static AuthRepository repository;
    private AsyncHttpClient client = new AsyncHttpClient();
    private RetrofitService apiService;
    private static final String TAG = "AuthRepository";

    private AuthRepository() {
        apiService = RetrofitService.getInstance();
    }

    public static AuthRepository getInstance() {
        if (repository == null) {
            repository = new AuthRepository();
        }
        return repository;
    }

    public synchronized void resetInstance() {
        if (repository != null) {
            repository = null;
        }
    }

    public MutableLiveData<String> register(User user) {
        final MutableLiveData<String> msg = new MutableLiveData<>();
        RequestParams params = new RequestParams();

        Map<String, String> registerData = new HashMap<>();
        registerData.put("email", user.getEmail());
        registerData.put("no_handphone", user.getPhoneNumber());
        registerData.put("password", user.getPassword());
        registerData.put("referral_code", user.getRef_code());

        mapToJson(registerData);

        client.post(BaseSetting.BASE_URL + "baycode/checkapi", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    String message = responseObject.getString("status");
                    msg.setValue(message);
                } catch (Exception e) {
                    Log.d("exceptionRegister", Objects.requireNonNull(e.getMessage()));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailureRegister", Objects.requireNonNull(error.getMessage()));
            }
        });
        return msg;
    }

    public MutableLiveData<UserSession> login(String email, String password) {
        final MutableLiveData<UserSession> userSessionData = new MutableLiveData<>();

        Map<String, String> loginInfo = new HashMap<>();
        loginInfo.put("email", email);
        loginInfo.put("password", password);

        apiService.login(mapToJson(loginInfo)).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body());
                        userSessionData.postValue(response.body().getResult());
                    }
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return userSessionData;
    }

    private JsonObject mapToJson(Map<String, String> map) {
        JsonObject object = new JsonObject();
        
        try {
            JSONObject params = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.put(entry.getKey(), entry.getValue());
            }
            JsonParser jsonParser = new JsonParser();
            object = (JsonObject) jsonParser.parse(params.toString());
            //print object
            Log.e("MapToJson:  ", "" + object);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return object;
    }
}
