package byc.avt.avanteeborrower.view.misc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.helper.PrefManager;
import byc.avt.avanteeborrower.view.onboarding.OnBoardingActivity;

public class NoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        Button btnClose = findViewById(R.id.btn_close);
        Button btnUnderstand = findViewById(R.id.btn_understand);
        PrefManager pref = new PrefManager(this);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Intent.ACTION_MAIN);
                a.addCategory(Intent.CATEGORY_HOME);
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(a);
            }
        });

        btnUnderstand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref.setOnBoarding(true);
                Intent intent = new Intent(NoticeActivity.this, OnBoardingActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
