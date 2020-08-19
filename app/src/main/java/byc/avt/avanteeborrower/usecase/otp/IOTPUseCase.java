package byc.avt.avanteeborrower.usecase.otp;

public interface IOTPUseCase {
    interface Action extends IOTPUseCase {
        void doSendMessage(String phoneNumber);

        void doCheckCode();
    }

    interface Views extends IOTPUseCase {
        void onCodeCorrect(boolean correct);

        void onSendFail(String msg);

        void onSendSuccess();
    }
}
