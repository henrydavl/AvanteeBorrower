package byc.avt.avanteeborrower.usecase.register;

import android.content.Context;

public interface IRegisterUseCase {
    interface Action extends IRegisterUseCase {
        void doCheckParam(Context context, String email, String phoneNumber, String password, String cPassword, String refId);

        void doRegister(Context context, String email, String phoneNumber, String password, String cPassword, String refId);

        void registerIdlingResource();

        void releaseIdlingResource();
    }

    interface Views extends IRegisterUseCase {
        void onProgressRegister();

        void onRegisterError(String msg);

        void onRegisterSuccess();

        void onParamAccepted(boolean accepted);

        void onInvalidParam(String msg);

        void onPhoneNumberVerified(boolean verified);
    }
}
