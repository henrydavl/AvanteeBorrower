package byc.avt.avanteeborrower.view.sheet;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;

import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.view.LoginActivity;

public class SheetMessageSent extends BottomSheetDialogFragment {

    private String phoneNumber;
    private TextView tvResend;
    private CountDownTimer timer;

    public SheetMessageSent(String phone) {
        this.phoneNumber = phone;
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
        timer.cancel();
        gotoLogin();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sheet_sms_sent, container, false);
        tvResend = v.findViewById(R.id.sheet_smsSent_tvResend);
        setTimer();
        return v;
    }

    /* todo send message to phone number */
    private View.OnClickListener resendListener = view -> {
        Toast.makeText(getActivity(), phoneNumber, Toast.LENGTH_SHORT).show();
        setTimer();
    };

    private void setTimer(){
        timer = new CountDownTimer(30000, 1000){
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                tvResend.setEnabled(false);
                tvResend.setText(String.format("%02d:%02d", seconds / 60, seconds % 60));
            }

            @Override
            public void onFinish() {
                tvResend.setEnabled(true);
                tvResend.setText(getString(R.string.resend));
                tvResend.setOnClickListener(resendListener);
            }
        }.start();
    }

    private void gotoLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.putExtra(LoginActivity.FROM_OTHER_ACTIVITY, "forgot_password");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        requireActivity().finish();
    }

}
