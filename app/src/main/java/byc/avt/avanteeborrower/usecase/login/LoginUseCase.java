package byc.avt.avanteeborrower.usecase.login;

import android.content.Context;

import byc.avt.avanteeborrower.usecase.BaseUseCase;

public class LoginUseCase extends BaseUseCase<ILoginUseCase.Views> implements ILoginUseCase.Action {

    public LoginUseCase(ILoginUseCase.Views view) {
        super(view);
    }

    @Override
    public void doLogin(Context context, String username, String password) {

    }

    @Override
    public void doInitialData(Context context, String userId) {

    }

    @Override
    public void registerIdlingResource() {

    }

    @Override
    public void releaseIdlingResource() {

    }
}
