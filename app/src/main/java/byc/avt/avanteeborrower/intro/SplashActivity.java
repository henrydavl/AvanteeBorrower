package byc.avt.avanteeborrower.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import byc.avt.avanteeborrower.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent onBoard = new Intent(SplashActivity.this, NoticeActivity.class);
                onBoard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(onBoard);
                finish();
            }
        }, 2000);
    }
}
