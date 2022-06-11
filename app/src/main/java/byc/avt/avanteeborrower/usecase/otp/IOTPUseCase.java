package byc.avt.avanteeborrower.usecase.otp;

public interface IOTPUseCase {
    void doSendMessage(String phoneNumber);

    void doCheckCode(String code);

    void onCodeCorrect(boolean correct);

    void onSendFail(String msg);

    void onSendSuccess();
}
