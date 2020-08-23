package byc.avt.avanteeborrower.usecase.otp;

import byc.avt.avanteeborrower.usecase.BaseUseCase;

public class OTPUseCase extends BaseUseCase<IOTPUseCase.Views> implements IOTPUseCase.Action {

    public OTPUseCase(Views view) {
        super(view);
    }

    @Override
    public void doSendMessage(String phoneNumber) {

    }

    @Override
    public void doCheckCode(String code) {

    }
}
