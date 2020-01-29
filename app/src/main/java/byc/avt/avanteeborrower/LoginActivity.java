package byc.avt.avanteeborrower;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private ActionBar actionBar;

    private TextInputLayout editPhoneNumber, editPassword;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editPhoneNumber = findViewById(R.id.edt_log_phone);
        editPassword = findViewById(R.id.edt_log_password);
        btnLogin = findViewById(R.id.btn_login);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_24px);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("");
        }
        Objects.requireNonNull(editPhoneNumber.getEditText()).addTextChangedListener(loginTextWatcher);
        Objects.requireNonNull(editPassword.getEditText()).addTextChangedListener(loginTextWatcher);
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
}
