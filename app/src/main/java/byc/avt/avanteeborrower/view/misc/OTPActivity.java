package byc.avt.avanteeborrower.view.misc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;


import byc.avt.avanteeborrower.R;

public class OTPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        Toolbar bar = findViewById(R.id.term_toolbar);
        bar.setNavigationIcon(R.drawable.ic_back_24px);
    }
}
