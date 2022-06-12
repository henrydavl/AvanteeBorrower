package byc.avt.avanteeborrower.view.main.dashboard;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.view.loanApplication.KTA.KTAApplicationActivity;
import byc.avt.avanteeborrower.view.loanApplication.KUTA.KUTAApplicationActivity;
import byc.avt.avanteeborrower.view.loanApplication.staff.StaffApplicationActivity;
import byc.avt.avanteeborrower.view.settings.general.SettingActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    @BindView(R.id.toolbar_fr_dashboard)
    Toolbar toolbar;

    @BindView(R.id.cv_staff_loan)
    CardView cvStaffLoan;

    @BindView(R.id.cv_kta_loan)
    CardView cvKTALoan;

    @BindView(R.id.cv_kuta_loan)
    CardView cvKUTALoan;

    public DashboardFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);

        cvStaffLoan.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), StaffApplicationActivity.class);
            startActivity(intent);
        });

        cvKTALoan.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), KTAApplicationActivity.class);
            startActivity(intent);
        });

        cvKUTALoan.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), KUTAApplicationActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onCreateOptionsMenu(@NotNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.dashboard_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_setting) {
            Intent intent = new Intent(getActivity(), SettingActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
