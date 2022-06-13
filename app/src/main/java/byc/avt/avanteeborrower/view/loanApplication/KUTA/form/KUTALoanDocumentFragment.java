package byc.avt.avanteeborrower.view.loanApplication.KUTA.form;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import byc.avt.avanteeborrower.R;

public class KUTALoanDocumentFragment extends Fragment {

    private Button next;

    public KUTALoanDocumentFragment() {
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
        return inflater.inflate(R.layout.fragment_kuta_loan_document, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        next = view.findViewById(R.id.btn_next_kuta_document);
        next.setOnClickListener(nextForm);
    }

    private final View.OnClickListener nextForm = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            NavDirections action = KUTALoanDocumentFragmentDirections.actionKUTALoanDocumentFragmentToKUTALoanApplicationFragment2();
            Navigation.findNavController(next).navigate(action);
        }
    };
}