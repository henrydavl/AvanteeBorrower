package byc.avt.avanteeborrower.view.loanApplication.KTA;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import byc.avt.avanteeborrower.R;

public class KTAApplicationActivity extends AppCompatActivity {

    private NavController navController;
    private AppBarLayout appBarLayout;
    private CoordinatorLayout coordinatorLayout;
    private CollapsingToolbarLayout toolbarLayout;
    private Toolbar toolbar;
    private AppBarConfiguration appBarConfiguration;
    private NavHostFragment navHostFragment;
    private Dialog dialog;
    private LinearLayout lineStep, regStep1, regStep2, regStep3, regStep4, regStep5, regStep6;
    private AppBarLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kta_application);

        appBarLayout = findViewById(R.id.appbar_kta_loan_form);
        toolbarLayout = findViewById(R.id.collapsing_kta_loan_form);
        params = (AppBarLayout.LayoutParams) toolbarLayout.getLayoutParams();
        toolbar = findViewById(R.id.toolbar_kta_loan_form);
        lineStep = findViewById(R.id.line_step_kta_loan);
        regStep1 = findViewById(R.id.step1);
        regStep2 = findViewById(R.id.step2);
        regStep3 = findViewById(R.id.step3);
        regStep4 = findViewById(R.id.step4);
        regStep5 = findViewById(R.id.step5);
        regStep6 = findViewById(R.id.step6);

        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.kta_loan_form_fragment_container);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }
        NavigationUI.setupWithNavController(toolbarLayout, toolbar, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, (Openable) null);
    }
}