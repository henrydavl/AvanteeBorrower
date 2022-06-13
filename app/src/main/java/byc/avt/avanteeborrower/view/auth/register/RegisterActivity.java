package byc.avt.avanteeborrower.view.auth.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.model.local.User;
import byc.avt.avanteeborrower.view.auth.AuthenticationViewModel;
import byc.avt.avanteeborrower.view.btSheet.TermFragment;
import byc.avt.avanteeborrower.view.misc.OTPActivity;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.edt_reg_phone)
    TextInputLayout editPhoneNumber;
    @BindView(R.id.edt_reg_password)
    TextInputLayout editPassword;
    @BindView(R.id.edt_reg_email)
    TextInputLayout edtEmail;
    @BindView(R.id.edt_reg_ref_id)
    TextInputLayout edtRefId;
    @BindView(R.id.edt_reg_re_password)
    TextInputLayout edtConfirmPassword;

    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.cb_agree)
    CheckBox checkAgree;
    @BindView(R.id.pb_register)
    ProgressBar pbRegister;
    @BindView(R.id.register_toolbar)
    Toolbar bar;

    private String phoneNumber, password, rePassword;
    private AuthenticationViewModel viewModel;
    private Boolean checkInput = false, readTerm = false;
    private Timer timer;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        setSupportActionBar(bar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_24px);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Objects.requireNonNull(editPhoneNumber.getEditText()).addTextChangedListener(registerTextWatcher);
        Objects.requireNonNull(editPassword.getEditText()).addTextChangedListener(registerTextWatcher);

        viewModel = new ViewModelProvider(this).get(AuthenticationViewModel.class);

        checkAgree.setOnCheckedChangeListener(showTermListener);
        btnRegister.setOnClickListener(view -> {
            showLoading(true);
            confirmInput();
        });
    }

    private CompoundButton.OnCheckedChangeListener showTermListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if (isChecked && TermFragment.read) {
                checkAgree.setChecked(true);
                readTerm = TermFragment.read;
            } else {
                TermFragment termFragment = TermFragment.getInstance();
                termFragment.show(getSupportFragmentManager(), termFragment.getTag());
                checkAgree.setChecked(false);
            }
        }
    };


    private TextWatcher registerTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String phoneNum = editPhoneNumber.getEditText().getText().toString().trim();
            String pass = editPassword.getEditText().getText().toString().trim();
            String rePass = edtConfirmPassword.getEditText().getText().toString().trim();
            checkInput = !phoneNum.isEmpty() && !pass.isEmpty() && !rePass.isEmpty();
//            if (checkInput && readTerm){
//                btnRegister.setEnabled(true);
//            } else {
//                btnRegister.setEnabled(false);
//            }
//            if (timer != null){
//                timer.cancel();
//            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
//            timer = new Timer();
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    String phoneNum = editPhoneNumber.getEditText().getText().toString().trim();
//                    String pass = editPassword.getEditText().getText().toString().trim();
//                    String rePass = edtConfirmPassword.getEditText().getText().toString().trim();
//                    checkInput = !phoneNum.isEmpty() && !pass.isEmpty() && !rePass.isEmpty();
//                }
//            }, 100);
            if (checkInput && readTerm){
                btnRegister.setEnabled(true);
            } else {
                btnRegister.setEnabled(false);
            }
        }
    };

    private boolean checkPassword(){
        password = editPassword.getEditText().getText().toString().trim();
        rePassword = edtConfirmPassword.getEditText().getText().toString().trim();
        if (rePassword.equals(password)){
            edtConfirmPassword.setError(null);
            return true;
//            if (PASSWORD_PATTERN.matcher(password).matches()){
//                editPassword.setError(null);
//                return true;
//            } else {
//                editPassword.setError("Password terlalu lemah");
//                return false;
//            }
        } else {
            edtConfirmPassword.setError("Kata Sandi Tidak Sama");
            return false;
        }
    }

    private boolean validateEmail(String email){
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtEmail.setError("Email tidak valid");
            return false;
        } else {
            edtEmail.setError(null);
            return true;
        }
    }

    private boolean validatePhoneNumber(String phone){
        if (phone.length() < 12){
            editPhoneNumber.setError("No. Telepon tidak valid");
            return false;
        } else {
            editPhoneNumber.setError(null);
            return true;
        }
    }

    public void confirmInput() {
        phoneNumber = editPhoneNumber.getEditText().getText().toString().trim();
        String email = Objects.requireNonNull(edtEmail.getEditText()).getText().toString().trim();
        String ref_id = Objects.requireNonNull(edtRefId.getEditText()).getText().toString().trim();
        if (!email.isEmpty()){
            checkPassword();
            validatePhoneNumber(phoneNumber);
            validateEmail(email);
        } else {
            if (!checkPassword() | !validatePhoneNumber(phoneNumber)) {
                return;
            }
            // POST to server through endpoint
            user = new User(phoneNumber, email, password, ref_id);
//            viewModel.register(user);
//            viewModel.getStatus().observe(this, checkStatus);
            Intent otp = new Intent(RegisterActivity.this, OTPActivity.class);
            otp.putExtra(OTPActivity.NEW_USER, user);
            startActivity(otp);
        }
    }

    private Observer<String> checkStatus = new Observer<String>() {
        @Override
        public void onChanged(String s) {
            if (s.equals("ok")) {
                showToast("Success");
                showLoading(false);
                //intent to sms verification
                Intent otp = new Intent(RegisterActivity.this, OTPActivity.class);
                otp.putExtra(OTPActivity.NEW_USER, user);
                startActivity(otp);
            } else {
                showToast("Failed");
            }
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (TermFragment.getInstance().isVisible()){
                TermFragment.getInstance().dismiss();
            } else {
                onBackPressed();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void showLoading(Boolean loading) {
        if (loading){
            btnRegister.setVisibility(View.INVISIBLE);
            pbRegister.setVisibility(View.VISIBLE);
        } else {
            pbRegister.setVisibility(View.INVISIBLE);
            btnRegister.setVisibility(View.VISIBLE);
        }
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
