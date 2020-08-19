package byc.avt.avanteeborrower.usecase.register;

import android.content.Context;

import byc.avt.avanteeborrower.usecase.BaseUseCase;
import byc.avt.avanteeborrower.usecase.login.ILoginUseCase;

public class RegisterUseCase extends BaseUseCase<IRegisterUseCase.Views> implements IRegisterUseCase.Action {

    public RegisterUseCase(IRegisterUseCase.Views view) {
        super(view);
    }

    @Override
    public void doCheckParam(Context context, String email, String phoneNumber, String password, String cPassword, String refId) {

    }

    @Override
    public void doRegister(Context context, String email, String phoneNumber, String password, String cPassword, String refId) {

    }

    @Override
    public void registerIdlingResource() {

    }

    @Override
    public void releaseIdlingResource() {

    }
}
