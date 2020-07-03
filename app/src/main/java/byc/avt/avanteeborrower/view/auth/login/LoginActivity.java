package byc.avt.avanteeborrower.view.auth.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.view.auth.forgotPassword.ForgotPasswordActivity;
import byc.avt.avanteeborrower.view.onboarding.OnBoardingActivity;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edt_log_phone)
    TextInputLayout editPhoneNumber;
    @BindView(R.id.edt_log_password)
    TextInputLayout editPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_forgot_password)
    TextView tvForgotPassword;
    @BindView(R.id.toolbar_login)
    Toolbar toolbar;

    public static String FROM_OTHER_ACTIVITY = "FROM_OTHER_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_24px);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Objects.requireNonNull(editPhoneNumber.getEditText()).addTextChangedListener(loginTextWatcher);
        Objects.requireNonNull(editPassword.getEditText()).addTextChangedListener(loginTextWatcher);

        tvForgotPassword.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String phoneNumber = editPhoneNumber.getEditText().getText().toString().trim();
            String password = editPassword.getEditText().getText().toString().trim();
            btnLogin.setEnabled(!phoneNumber.isEmpty() && !password.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private boolean validatePhoneNumber () {
        String phoneNumber = editPhoneNumber.getEditText().getText().toString().trim();

        if (phoneNumber.isEmpty()) {
            editPhoneNumber.setError("Filed can't be empty");
            return false;
        } else {
            editPhoneNumber.setError(null);
            return true;
        }
    }

    private boolean validatePassword () {
        String password = editPassword.getEditText().getText().toString().trim();

        if (password.isEmpty()) {
            editPassword.setError("Filed can't be empty");
            return false;
        } else {
            editPassword.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (validatePassword() | validatePassword()) {

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (getIntent().getStringExtra(FROM_OTHER_ACTIVITY) != null){
            if (item.getItemId() == android.R.id.home) {
                Intent intent = new Intent(LoginActivity.this, OnBoardingActivity.class);
                intent.putExtra(OnBoardingActivity.notFirstTime, true);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        } else {
            if (item.getItemId() == android.R.id.home) {
                onBackPressed();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
