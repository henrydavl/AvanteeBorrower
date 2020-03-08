package byc.avt.avanteeborrower.view;

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

import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.view.misc.ForgotPasswordActivity;
import byc.avt.avanteeborrower.view.sheet.TermFragment;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout editPhoneNumber, editPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editPhoneNumber = findViewById(R.id.edt_log_phone);
        editPassword = findViewById(R.id.edt_log_password);
        btnLogin = findViewById(R.id.btn_login);
        TextView tvForgotPassword = findViewById(R.id.tv_forgot_password);
        Toolbar bar = findViewById(R.id.toolbar_login);
        setSupportActionBar(bar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_back_24px);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(editPhoneNumber.getEditText()).addTextChangedListener(loginTextWatcher);
        Objects.requireNonNull(editPassword.getEditText()).addTextChangedListener(loginTextWatcher);
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
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
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
