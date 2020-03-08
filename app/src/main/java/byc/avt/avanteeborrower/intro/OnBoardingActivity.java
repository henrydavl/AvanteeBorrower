package byc.avt.avanteeborrower.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.adapter.OnBoardAdapter;
import byc.avt.avanteeborrower.helper.PrefManager;

public class OnBoardingActivity extends AppCompatActivity {

    private LinearLayout onBoardDots;
    private Button btnSkip;
    private String[] board_heading;
    public static final String notFirstTime = "notFirstTime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        final ViewPager onBoardPager = findViewById(R.id.onBoardPager);
        onBoardDots = findViewById(R.id.onBoardDots);
        btnSkip = findViewById(R.id.btnSkip);
        board_heading = getResources().getStringArray(R.array.onboard_heading);
        OnBoardAdapter onBoardAdapter = new OnBoardAdapter(this);
        onBoardPager.setAdapter(onBoardAdapter);
        dotsIndicator(0);
        onBoardPager.addOnPageChangeListener(listener);

        if (getIntent().getBooleanExtra(notFirstTime, false)){
            boolean check = getIntent().getBooleanExtra(notFirstTime, false);
            if (check){
                onBoardPager.setCurrentItem(board_heading.length);
            }
        }

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBoardPager.setCurrentItem(board_heading.length);
            }
        });
    }

    public void dotsIndicator(int position) {
        TextView[] dots = new TextView[board_heading.length];
        onBoardDots.removeAllViews();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(8,0,8,0);

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(32);
            dots[i].setLayoutParams(params);
            dots[i].setTextColor(getResources().getColor(R.color.neutral));
            onBoardDots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            dotsIndicator(position);

            if (position == board_heading.length - 1) {
                btnSkip.setEnabled(false);
                btnSkip.setVisibility(View.INVISIBLE);
            } else {
                btnSkip.setEnabled(true);
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
