package byc.avt.avanteeborrower.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.adapter.OnBoardAdapter;

public class OnBoardingActivity extends AppCompatActivity {

    private ViewPager onBoardPager;
    private TextView[] dots;
    private OnBoardAdapter onBoardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        onBoardPager = findViewById(R.id.onBoardPager);
        onBoardAdapter = new OnBoardAdapter(this);
        onBoardPager.setAdapter(onBoardAdapter);
    }

    public void dotsIndicator() {

    }
}
