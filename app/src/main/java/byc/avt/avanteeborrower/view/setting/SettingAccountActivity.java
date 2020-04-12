package byc.avt.avanteeborrower.view.setting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

import byc.avt.avanteeborrower.R;

public class SettingAccountActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_account);

        Toolbar toolbar = findViewById(R.id.toolbar_acc_settings);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_back_24px);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CardView cvChangePassword = findViewById(R.id.cv_change_password);
        CardView cvPersonalData = findViewById(R.id.cv_personal_data);
        CardView cvWorkInfo = findViewById(R.id.cv_work_info);
        CardView cvAddresses = findViewById(R.id.cv_address_info);
        CardView cvOtherFam = findViewById(R.id.cv_other_fam);
        CardView cvBankInfo = findViewById(R.id.cv_bank_info);
        CardView cvEssDoc = findViewById(R.id.cv_ess_doc);
        ImageView imgProfile = findViewById(R.id.img_profile_picture);

        cvChangePassword.setOnClickListener(this);
        cvPersonalData.setOnClickListener(this);
        cvWorkInfo.setOnClickListener(this);
        cvAddresses.setOnClickListener(this);
        cvOtherFam.setOnClickListener(this);
        cvBankInfo.setOnClickListener(this);
        cvEssDoc.setOnClickListener(this);
        imgProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.img_profile_picture:
                //display bottom sheet
                break;
            case R.id.cv_change_password:
                intent = new Intent(SettingAccountActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_personal_data:
                showMessage("View Personal data");
                break;
            case R.id.cv_work_info:
                showMessage("View work info");
                break;
            case R.id.cv_address_info:
                showMessage("View Addresses");
                break;
            case R.id.cv_other_fam:
                showMessage("View other fam");
                break;
            case R.id.cv_bank_info:
                showMessage("View bank info");
                break;
            case R.id.cv_ess_doc:
                showMessage("View ess doc");
                break;
        }
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
