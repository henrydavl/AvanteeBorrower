package byc.avt.avanteeborrower.view.auth;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import byc.avt.avanteeborrower.model.local.User;
import byc.avt.avanteeborrower.model.response.UserSession;

public class AuthenticationViewModel extends AndroidViewModel {
    private MutableLiveData<String> isSuccess = new MutableLiveData<>();
    private AuthRepository authRepository;

    public AuthenticationViewModel(@NonNull Application application) {
        super(application);
        authRepository = AuthRepository.getInstance();
    }

    public void register(User user){
        isSuccess = authRepository.register(user);
    }

    public LiveData<String> getStatus(){
        return isSuccess;
    }

    public LiveData<UserSession> login(String email, String password) {
        return authRepository.login(email, password);
    }
}
