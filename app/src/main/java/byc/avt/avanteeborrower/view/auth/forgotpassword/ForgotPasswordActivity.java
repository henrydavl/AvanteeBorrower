package byc.avt.avanteeborrower.view.auth.forgotpassword;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.view.sheet.SheetMessageSent;

public class ForgotPasswordActivity extends AppCompatActivity {

    private TextInputLayout phoneNumber;
    private Button btnSend;
    private String phone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Toolbar toolbar = findViewById(R.id.forgotPassword_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_close);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        phoneNumber = findViewById(R.id.edit_f_pass_phone);
        Objects.requireNonNull(phoneNumber.getEditText()).addTextChangedListener(fgPasswordTextWatcher);
        btnSend = findViewById(R.id.btn_reset_password);
        btnSend.setOnClickListener(view -> openSheet(phone));
    }

    private TextWatcher fgPasswordTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            phone = Objects.requireNonNull(phoneNumber.getEditText()).getText().toString().trim();
            btnSend.setEnabled(!phone.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void openSheet(String phone) {
        SheetMessageSent messageSent = new SheetMessageSent(phone);
        messageSent.show(getSupportFragmentManager(), messageSent.getTag());
    }

    private void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
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
