package byc.avt.avanteeborrower.view.registration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.google.android.material.appbar.AppBarLayout;

import byc.avt.avanteeborrower.R;

public class RegistrationFormActivity extends AppCompatActivity {

    private NavController navController;
    AppBarLayout appBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        appBarLayout = findViewById(R.id.appbar_regis_forn);
        //appBarLayout.setVisibility(View.GONE);
        Toolbar toolbar = findViewById(R.id.register_form_toolbar);
//        setSupportActionBar(toolbar);
        navController = Navigation.findNavController(this, R.id.register_form_fragment_container);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                Toast.makeText(RegistrationFormActivity.this, destination.getLabel(), Toast.LENGTH_SHORT).show();
                switch (destination.getLabel().toString().trim()){
                    case "fragment_personal_data" :
                        appBarLayout.setVisibility(View.VISIBLE);
                        getSupportActionBar().show();
                        //getSupportActionBar().setTitle("AAA");
//                        setSupportActionBar(toolbar);
                        break;
                    case "fragment_document" :
                        appBarLayout.setVisibility(View.VISIBLE);
                        getSupportActionBar().show();
                        toolbar.setTitle(R.string.essential_document);
                        break;
                    case "fragment_welcome" :
                        getSupportActionBar().hide();
                        appBarLayout.setVisibility(View.GONE);
                        break;
                }
//                if (R.layout.fragment_personal_data.equals(destination.getLabel())) {
//                    appBarLayout.setVisibility(View.VISIBLE);
//                    toolbar.setTitle(R.string.personal_data);
//                }
            }
        });
        setSupportActionBar(toolbar);
//        NavigationUI.setupActionBarWithNavController(this, navController);
        NavigationUI.setupWithNavController(toolbar, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, (DrawerLayout) null);
    }
}
