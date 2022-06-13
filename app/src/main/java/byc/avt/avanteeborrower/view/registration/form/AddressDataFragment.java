 package byc.avt.avanteeborrower.view.registration.form;

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

import byc.avt.avanteeborrower.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddressDataFragment extends Fragment{

    private Button next;
    private CheckBox checkDom, checkWork;
    private ConstraintLayout consBom, consWork;

    public AddressDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_address_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_24px);
        next = view.findViewById(R.id.btn_next_address_info);
        checkDom = view.findViewById(R.id.cb_domicile_same_as_ktp);
        checkWork = view.findViewById(R.id.cb_work_same_as_ktp);
        consBom = view.findViewById(R.id.cons_dom_same_as_ktp);
        consWork = view.findViewById(R.id.cons_work_same_as_ktp);

        checkDom.setOnCheckedChangeListener(checkDomListener);
        checkWork.setOnCheckedChangeListener(checkWorkListener);
        next.setOnClickListener(nextForm);
    }

    private CompoundButton.OnCheckedChangeListener checkDomListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
            if (checked) {
                consBom.setVisibility(View.GONE);
            } else {
                consBom.setVisibility(View.VISIBLE);
            }
        }
    };

    private CompoundButton.OnCheckedChangeListener checkWorkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
            if (checked) {
                consWork.setVisibility(View.GONE);
            } else {
                consWork.setVisibility(View.VISIBLE);
            }
        }
    };

    private View.OnClickListener nextForm = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            NavDirections action = AddressDataFragmentDirections.actionOtherFamily();
            Navigation.findNavController(next).navigate(action);
        }
    };
}
