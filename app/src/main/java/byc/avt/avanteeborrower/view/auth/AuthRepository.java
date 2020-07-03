package byc.avt.avanteeborrower.view.auth;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.Objects;

import byc.avt.avanteeborrower.model.User;
import cz.msebera.android.httpclient.Header;

import static byc.avt.avanteeborrower.helper.constants.Constant.*;

public class AuthRepository {
    private static AuthRepository repository;
//    private String baseUrl = BASE_URL;
    private AsyncHttpClient client = new AsyncHttpClient();

    private AuthRepository() {
        client.addHeader("Accept", TYPE);
        client.addHeader("Content-Type: ", TYPE);
        client.addHeader("Authorization", basicAuth);
        client.addHeader("X-API-KEY", X_API_KEY);
    }

    public static AuthRepository getInstance() {
        if (repository == null) {
            repository = new AuthRepository();
        }
        return repository;
    }

    public MutableLiveData<String> register(User user){
        final MutableLiveData<String> msg = new MutableLiveData<>();
        RequestParams params = new RequestParams();
        params.put("email", user.getEmail());
        params.put("no_handphone", user.getPhoneNumber());
        params.put("password", user.getPassword());
        params.put("referral_code", user.getRef_code());
        client.post(BASE_URL+"baycode/checkapi", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    String message = responseObject.getString("status");
                    msg.setValue(message);
                } catch (Exception e){
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

//    public MutableLiveData<String> login(String phone, String password, Context context){
//        final MutableLiveData<String> msg = new MutableLiveData<>();
//        return msg;
//    }
}
