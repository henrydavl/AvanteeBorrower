package byc.avt.avanteeborrower.usecase.login;

import android.content.Context;

public interface ILoginUseCase {
    interface Action extends ILoginUseCase {
        void doLogin(String username, String password);

        void doInitialData(Context context, String userId);

        void registerIdlingResource();

        void releaseIdlingResource();
    }

    interface Views extends ILoginUseCase {
        void onProgressLogin();

        void onProgressInitialData(String msg);

        void onLoginError(String msg);

        void onLoginSuccess();

        void onInvalidParam(String msg);

        void onInitialDataSuccess();

        void onInitialDataError();
    }
}
