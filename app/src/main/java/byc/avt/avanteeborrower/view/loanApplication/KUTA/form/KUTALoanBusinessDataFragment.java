package byc.avt.avanteeborrower.view.loanApplication.KUTA.form;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.view.registration.form.AddressDataFragmentDirections;

public class KUTALoanBusinessDataFragment extends Fragment {

    private Button next;
    private RadioGroup isOnline;
    private CheckBox isMarketplace, isSocial, isWebsite;
    private ConstraintLayout consMarketplace, consSocial, consWebsite;

    public KUTALoanBusinessDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kuta_loan_business_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        next = view.findViewById(R.id.btn_next_kuta_business_data);
        isMarketplace = view.findViewById(R.id.cb_is_business_in_marketplace);
        isSocial = view.findViewById(R.id.cb_is_business_social_media);
        isWebsite = view.findViewById(R.id.cb_is_business_website);
        consMarketplace = view.findViewById(R.id.cons_business_in_marketplace);
        consSocial = view.findViewById(R.id.cons_business_in_social_media);
        consWebsite = view.findViewById(R.id.cons_business_is_website);
        isOnline = view.findViewById(R.id.radio_bus_is_online);

        setupInitialView();

        isOnline.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.radio_bus_yes:
                    unHideCheckBox();
                    break;
                case R.id.radio_bus_no:
                    setupInitialView();
                    break;
            }
        });

        next.setOnClickListener(nextForm);
    }

    private void unHideCheckBox() {
        isMarketplace.setVisibility(View.VISIBLE);
        isSocial.setVisibility(View.VISIBLE);
        isWebsite.setVisibility(View.VISIBLE);

        isMarketplace.setOnCheckedChangeListener(checkMarketplaceListener);
        isSocial.setOnCheckedChangeListener(checkSocialListener);
        isWebsite.setOnCheckedChangeListener(checkWebsiteListener);
    }

    private void setupInitialView() {
        isMarketplace.setVisibility(View.GONE);
        isSocial.setVisibility(View.GONE);
        isWebsite.setVisibility(View.GONE);
        consMarketplace.setVisibility(View.GONE);
        consSocial.setVisibility(View.GONE);
        consWebsite.setVisibility(View.GONE);
    }

    private CompoundButton.OnCheckedChangeListener checkMarketplaceListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
            if (checked) {
                consMarketplace.setVisibility(View.VISIBLE);
            } else {
                consMarketplace.setVisibility(View.GONE);
            }
        }
    };

    private CompoundButton.OnCheckedChangeListener checkSocialListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
            if (checked) {
                consSocial.setVisibility(View.VISIBLE);
            } else {
                consSocial.setVisibility(View.GONE);
            }
        }
    };

    private CompoundButton.OnCheckedChangeListener checkWebsiteListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
            if (checked) {
                consWebsite.setVisibility(View.VISIBLE);
            } else {
                consWebsite.setVisibility(View.GONE);
            }
        }
    };

    private View.OnClickListener nextForm = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            NavDirections action = KUTALoanBusinessDataFragmentDirections.actionKUTALoanBussinessDataFragmentToKUTALoanPurposeFragment();
            Navigation.findNavController(next).navigate(action);
        }
    };
}