package byc.avt.avanteeborrower.view.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import byc.avt.avanteeborrower.model.User;
import byc.avt.avanteeborrower.model.UserSession;

public class AuthenticationViewModel extends ViewModel {
    private MutableLiveData<String> isSuccess = new MutableLiveData<>();
    private AuthRepository authRepository;

    public AuthenticationViewModel() {
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
