package byc.avt.avanteeborrower.view.setting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

import byc.avt.avanteeborrower.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Toolbar toolbar = findViewById(R.id.toolbar_settings);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_back_24px);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CardView cvAccountSetting = findViewById(R.id.cv_account_setting);
        CardView cvFAQ = findViewById(R.id.cv_faq);
        CardView cvTerms = findViewById(R.id.cv_terms);
        CardView cvRisk = findViewById(R.id.cv_risk_info);
        CardView cvLogout = findViewById(R.id.cv_logout); // logout button

        cvAccountSetting.setOnClickListener(this);
        cvFAQ.setOnClickListener(this);
        cvTerms.setOnClickListener(this);
        cvRisk.setOnClickListener(this);
        cvLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.cv_account_setting:
                intent = new Intent(SettingActivity.this, SettingAccountActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_faq:
                showMessage("Goto FAQ");
                break;
            case R.id.cv_terms:
                showMessage("Goto Terms Condition");
                break;
            case R.id.cv_risk_info:
                showMessage("Goto Risk info");
                break;
            case R.id.cv_logout:
                showMessage("Logged out");
                //perform logout action
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
