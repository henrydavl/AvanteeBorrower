package byc.avt.avanteeborrower.view.registration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Objects;

import byc.avt.avanteeborrower.R;

public class RegistrationFormActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_registration_form);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        appBarLayout = findViewById(R.id.appbar_regis_forn);
        toolbarLayout = findViewById(R.id.collapsing_regis_form);
        params = (AppBarLayout.LayoutParams) toolbarLayout.getLayoutParams();
        toolbar = findViewById(R.id.register_form_toolbar);
        lineStep = findViewById(R.id.line_step_regis_form);
        lineStep.setVisibility(View.GONE);
        regStep1 = findViewById(R.id.step1);
        regStep2 = findViewById(R.id.step2);
        regStep3 = findViewById(R.id.step3);
        regStep4 = findViewById(R.id.step4);
        regStep5 = findViewById(R.id.step5);
        regStep6 = findViewById(R.id.step6);

        navController = Navigation.findNavController(this, R.id.register_form_fragment_container);
        NavigationUI.setupWithNavController(toolbarLayout, toolbar, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            switch (destination.getId()){
                case R.id.welcomeFragment:
                    lineStep.setVisibility(View.GONE);
                    new Handler().postDelayed(() -> {
                        toolbarLayout.setVisibility(View.GONE);
                        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_NO_SCROLL
                                | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
                    }, 100);
                    break;
                case R.id.personalDataFragment:
                    params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                            | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
                    toolbarLayout.setVisibility(View.VISIBLE);
                    lineStep.setVisibility(View.VISIBLE);
                    break;
                case R.id.workInfoFragment:
                    lineStep.setVisibility(View.VISIBLE);
                    break;
                case R.id.addressDataFragment:
                    lineStep.setVisibility(View.VISIBLE);
                    break;
                case R.id.otherFamilyFragment:
                    lineStep.setVisibility(View.VISIBLE);
                    break;
                case R.id.bankInfoFragment:
                    lineStep.setVisibility(View.VISIBLE);
                    break;
                case R.id.documentFragment:
                    lineStep.setVisibility(View.VISIBLE);
                    break;
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, (DrawerLayout) null);
    }

    @Override
    public void onBackPressed() {
        if (Objects.requireNonNull(navController.getCurrentDestination()).getId() == R.id.welcomeFragment) {
            logoutConfirmation();
        }
    }

    private void logoutConfirmation(){
        new AlertDialog.Builder(RegistrationFormActivity.this)
                .setTitle("Konfirmasi")
                .setIcon(R.drawable.logo)
                .setMessage("Apakah anda yakin mau keluar dari pengisian data akun?")
                .setCancelable(false)
                .setPositiveButton(R.string.yes, (dialogInterface, i) -> {
//                        logout();
                })
                .setNegativeButton(R.string.no, (dialogs, which) -> dialogs.cancel())
                .create()
                .show();
    }
}
