package byc.avt.avanteeborrower.view.setting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import byc.avt.avanteeborrower.R;

public class ChangePasswordActivity extends AppCompatActivity {

    private TextInputLayout editOldPassword, editNewPassword, editConfirmNewPassword;
    private Button btnSaveNewPassword;
    private Boolean checkInput = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_change_password);

        Toolbar toolbar = findViewById(R.id.toolbar_change_password);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_back_24px);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editOldPassword = findViewById(R.id.edt_old_password);
        editNewPassword = findViewById(R.id.edt_new_password);
        editConfirmNewPassword = findViewById(R.id.edt_re_new_password);
        btnSaveNewPassword = findViewById(R.id.btn_save_new_password);

        editOldPassword.getEditText().addTextChangedListener(changePasswordWatcher);
        editNewPassword.getEditText().addTextChangedListener(changePasswordWatcher);
        editConfirmNewPassword.getEditText().addTextChangedListener(changePasswordWatcher);
        btnSaveNewPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmPassword();
            }
        });
    }

    private TextWatcher changePasswordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String oldPass = editOldPassword.getEditText().getText().toString().trim();
            String newPass = editNewPassword.getEditText().getText().toString().trim();
            String reNewPass = editConfirmNewPassword.getEditText().getText().toString().trim();
            checkInput = !oldPass.isEmpty() && !newPass.isEmpty() && !reNewPass.isEmpty();
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (checkInput){
                btnSaveNewPassword.setEnabled(true);
            } else {
                btnSaveNewPassword.setEnabled(false);
            }
        }
    };

    private void confirmPassword(){

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
