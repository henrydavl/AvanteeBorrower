package byc.avt.avanteeborrower.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.model.User;
import byc.avt.avanteeborrower.view.misc.TermFragment;
import byc.avt.avanteeborrower.viewmodel.AuthenticationViewModel;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout editPhoneNumber, editPassword, edtEmail, edtRefId, edtConfirmPassword;
    private String phoneNumber, password, rePassword;
    private Button btnRegister;
    private CheckBox checkAgree;
    private AuthenticationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtEmail = findViewById(R.id.edt_reg_email);
        editPhoneNumber = findViewById(R.id.edt_reg_phone);
        editPassword = findViewById(R.id.edt_reg_password);
        edtConfirmPassword = findViewById(R.id.edt_reg_re_password);
        edtRefId = findViewById(R.id.edt_reg_ref_id);
        btnRegister = findViewById(R.id.btn_register);
        checkAgree = findViewById(R.id.cb_remember_me);
        Toolbar bar = findViewById(R.id.register_toolbar);
        setSupportActionBar(bar);
        viewModel = ViewModelProviders.of(this).get(AuthenticationViewModel.class);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_back_24px);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(editPhoneNumber.getEditText()).addTextChangedListener(registerTextWatcher);
        Objects.requireNonNull(editPassword.getEditText()).addTextChangedListener(registerTextWatcher);
        checkAgree.setOnClickListener(showTermListener);
    }

    private View.OnClickListener showTermListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TermFragment termFragment = TermFragment.getInstance();
            termFragment.show(getSupportFragmentManager(), termFragment.getTag());
        }
    };


    private TextWatcher registerTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            phoneNumber = Objects.requireNonNull(editPhoneNumber.getEditText()).getText().toString().trim();
            password = Objects.requireNonNull(editPassword.getEditText()).getText().toString().trim();
            rePassword = Objects.requireNonNull(edtConfirmPassword.getEditText()).getText().toString().trim();
            btnRegister.setEnabled(!phoneNumber.isEmpty() && !password.isEmpty() && !rePassword.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private boolean checkPassword(){
        if (rePassword.equals(password)){
            edtConfirmPassword.setError(null);
            return true;
        } else {
            return false;
        }
    }

    public void confirmInput(View v) {
        if (!checkPassword()) {
            edtConfirmPassword.setError("Kata Sandi Tidak Sama");
        } else {
            String email = Objects.requireNonNull(edtEmail.getEditText()).getText().toString().trim();
            String ref_id = Objects.requireNonNull(edtRefId.getEditText()).getText().toString().trim();
            // POST to server through endpoint
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setPhoneNumber(phoneNumber);
            viewModel.register(user, ref_id);
            viewModel.getStatus().observe(this, checkStatus);
        }
    }

    private Observer<Boolean> checkStatus = new Observer<Boolean>() {
        @Override
        public void onChanged(Boolean aBoolean) {
            if (aBoolean) {
                showMessage("Success");
                //intent to sms verification

            } else {
                showMessage("failed");
            }
        }
    };

    private void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
