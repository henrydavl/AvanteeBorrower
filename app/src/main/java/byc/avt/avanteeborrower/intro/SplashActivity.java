package byc.avt.avanteeborrower.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.helper.PrefManager;
import byc.avt.avanteeborrower.view.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        PrefManager pref = new PrefManager(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (pref.getOnBoarding()){
                    Intent onBoard = new Intent(SplashActivity.this, OnBoardingActivity.class);
                    onBoard.putExtra(OnBoardingActivity.notFirstTime, true);
                    onBoard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(onBoard);
                    finish();
                } else {
                    Intent notice = new Intent(SplashActivity.this, NoticeActivity.class);
                    notice.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(notice);
                    finish();
                }
            }
        }, 2000);
    }
}
