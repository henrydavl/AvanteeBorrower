package byc.avt.avanteeborrower.viewmodel;

import android.content.Context;
import android.os.Build;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import byc.avt.avanteeborrower.BuildConfig;
import byc.avt.avanteeborrower.model.User;
import byc.avt.avanteeborrower.repository.AuthRepository;

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
}
