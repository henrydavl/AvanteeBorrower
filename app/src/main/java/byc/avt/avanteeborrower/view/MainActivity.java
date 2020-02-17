package byc.avt.avanteeborrower.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.view.fragment.DashboardFragment;
import byc.avt.avanteeborrower.view.fragment.LoanFragment;
import byc.avt.avanteeborrower.view.fragment.NotificationFragment;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            actionBar.setDisplayShowHomeEnabled(true);
            switch (item.getItemId()) {
                case R.id.nav_dashboard:
                    actionBar.setIcon(R.drawable.ic_dashboard);
                    actionBar.setTitle(" " + getString(R.string.nav_dashboard));
                    fragment = new DashboardFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_loan:
                    actionBar.setIcon(R.drawable.ic_loan_color);
                    actionBar.setTitle(" " + getString(R.string.nav_loan));
                    fragment = new LoanFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_notification:
                    actionBar.setIcon(R.drawable.ic_notification_color);
                    actionBar.setTitle(" " + getString(R.string.nav_notification));
                    fragment = new NotificationFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_layout, fragment);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        BottomNavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (savedInstanceState == null) {
            navigationView.setSelectedItemId(R.id.nav_dashboard);
        }
    }

    public boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onResume() {
        super.onResume();
        this.doubleBackToExitPressedOnce = false;
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(a);
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(MainActivity.this, R.string.press_exit, Toast.LENGTH_SHORT).show();
    }
}
