package byc.avt.avanteeborrower.view.auth.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.view.auth.AuthenticationViewModel;
import byc.avt.avanteeborrower.view.auth.forgotPassword.ForgotPasswordActivity;
import byc.avt.avanteeborrower.view.main.MainActivity;
import byc.avt.avanteeborrower.view.onboarding.OnBoardingActivity;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edt_log_email)
    TextInputLayout editEmailAddress;
    @BindView(R.id.edt_log_password)
    TextInputLayout editPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_forgot_password)
    TextView tvForgotPassword;
    @BindView(R.id.toolbar_login)
    Toolbar toolbar;

    public static String FROM_OTHER_ACTIVITY = "FROM_OTHER_ACTIVITY";
    private String email, password;
    private AuthenticationViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_24px);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        viewModel = new ViewModelProvider(this).get(AuthenticationViewModel.class);

        Objects.requireNonNull(editEmailAddress.getEditText()).addTextChangedListener(loginTextWatcher);
        Objects.requireNonNull(editPassword.getEditText()).addTextChangedListener(loginTextWatcher);

        tvForgotPassword.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
//            doLogin(email, password);
        });
    }

    private void doLogin(String email, String password) {

        viewModel.login(email, password).observe(this, userSession -> {
            if (userSession != null) {
                showToast(userSession.getName());
            } else {
                showToast("Login Failed");
            }
        });

    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            email = editEmailAddress.getEditText().getText().toString().trim();
            password = editPassword.getEditText().getText().toString().trim();
            btnLogin.setEnabled(!email.isEmpty() && !password.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {
//            btnLogin.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    useCase.doLogin(email, password);
//                }
//            });
        }
    };



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

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
