package byc.avt.avanteeborrower.view.settings.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Objects;

import byc.avt.avanteeborrower.R;

/**
 * @link #onClick(View view) to trigger when a button is clickked
 * */

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
        ImageView editCircle = findViewById(R.id.img_edit_circle);
        TextView tvInitials = findViewById(R.id.tv_initial2);

        String name = "Henry David Lie";
        String letter = String.valueOf(name.charAt(0));
        tvInitials.setText(letter);

        cvChangePassword.setOnClickListener(this);
        cvPersonalData.setOnClickListener(this);
        cvWorkInfo.setOnClickListener(this);
        cvAddresses.setOnClickListener(this);
        cvOtherFam.setOnClickListener(this);
        cvBankInfo.setOnClickListener(this);
        cvEssDoc.setOnClickListener(this);
        imgProfile.setOnClickListener(this);
        editCircle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.img_profile_picture:
            case R.id.img_edit_circle:
                openSheet();
                break;
            case R.id.cv_change_password:
                intent = new Intent(SettingAccountActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_personal_data:
                intent = new Intent(SettingAccountActivity.this, PersonalDataActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_work_info:
                intent = new Intent(SettingAccountActivity.this, WorkInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_address_info:
                intent = new Intent(SettingAccountActivity.this, AddressesActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_other_fam:
                intent = new Intent(SettingAccountActivity.this, FamilyInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_bank_info:
                intent = new Intent(SettingAccountActivity.this, BankInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_ess_doc:
                intent = new Intent(SettingAccountActivity.this, EssentialDocumentActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void openSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(SettingAccountActivity.this, R.style.BottomSheetDialogTheme);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.sheet_profile_edit, findViewById(R.id.btSheet_profPic));
        bottomSheetView.findViewById(R.id.btn_take_profile_picture).setOnClickListener(view1 -> {
            showMessage("Take picture");
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
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
