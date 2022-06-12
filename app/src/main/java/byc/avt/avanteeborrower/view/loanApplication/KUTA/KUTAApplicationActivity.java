package byc.avt.avanteeborrower.view.loanApplication.KUTA;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import byc.avt.avanteeborrower.R;

public class KUTAApplicationActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_kuta_application);
    }
}