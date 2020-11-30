package byc.avt.avanteeborrower.view.misc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.helper.receiver.OTPReceiver;
import byc.avt.avanteeborrower.helper.widget.PinViewEditText;
import byc.avt.avanteeborrower.model.local.User;
import byc.avt.avanteeborrower.usecase.otp.IOTPUseCase;
import byc.avt.avanteeborrower.usecase.otp.OTPUseCase;
import byc.avt.avanteeborrower.view.BaseActivity;

public class OTPActivity extends BaseActivity<OTPUseCase> implements IOTPUseCase.Views {

    @BindView(R.id.tv_countdown)
    TextView tvCountdown;
    @BindView(R.id.tv_otp_sent_to)
    TextView tvSendTo;
    @BindView(R.id.btn_verify)
    Button btnVerify;
    @BindView(R.id.edt_otp_code)
    PinViewEditText otpView;
    @BindView(R.id.otp_toolbar)
    Toolbar toolbar;

    public static final String NEW_USER = "new_user";
    private User user;

    private CountDownTimer timer;

    @Override
    protected OTPUseCase initUseCase() {
        return new OTPUseCase((this));
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_otp;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreated(Bundle savedInstanceState) {
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if  (getSupportActionBar() != null) {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_24px);
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if (getIntent().getParcelableExtra(NEW_USER) != null) {
            user = getIntent().getParcelableExtra(NEW_USER);
            tvSendTo.setText(getString(R.string.otp_desc) + user.getPhoneNumber());
        }

        useCase.doSendMessage(user.getPhoneNumber());

        setTimer();
    }

    private void setTimer() {
        timer = new CountDownTimer(30000, 1000) {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                tvCountdown.setEnabled(false);
                tvCountdown.setText(getString(R.string.resend_in) + String.format("%02d:%02d", seconds / 60, seconds % 60));
            }

            @Override
            public void onFinish() {
                tvCountdown.setEnabled(true);
                tvCountdown.setText(getString(R.string.resend));
            }
        }.start();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCodeCorrect(boolean correct) {
        // register and open bottom sheet
    }

    @Override
    public void onSendFail(String msg) {
        // retry or back to register
    }

    @Override
    public void onSendSuccess() {
        //listen to edit sms
        new OTPReceiver().setEditText(otpView);
        btnVerify.setEnabled(true);
    }

    @OnClick({
            R.id.btn_verify,
            R.id.tv_otp_sent_to
    })
    public void onClick(android.view.View view) {
        String msg = "Coming soon";
        switch (view.getId()) {
            case R.id.tv_otp_sent_to:
                /* todo send new otp code */
                showToast(msg);
                setTimer();
                break;
            case R.id.btn_verify:
                showToast(msg);
                useCase.doCheckCode(otpView.getValue());
                break;
        }
    }
}
