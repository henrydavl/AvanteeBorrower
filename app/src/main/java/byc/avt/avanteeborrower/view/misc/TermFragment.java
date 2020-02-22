package byc.avt.avanteeborrower.view.misc;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;

import byc.avt.avanteeborrower.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TermFragment extends BottomSheetDialogFragment{

    @SuppressLint("StaticFieldLeak")
    private static TermFragment instance;
    public static Boolean read = false;
    private Button btnCancel, btnNext;
    private CheckBox cbRead;

    public TermFragment() {

    }

    public static TermFragment getInstance() {
        if (instance == null) {
            instance = new TermFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_term, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = view.findViewById(R.id.term_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_close);
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        NestedScrollView nestedScrollView = view.findViewById(R.id.nested_scroll_term);
        btnCancel = view.findViewById(R.id.btn_term_cancel);
        btnNext = view.findViewById(R.id.btn_term_next);
        cbRead = view.findViewById(R.id.cb_term_read);

        nestedScrollView.setOnScrollChangeListener(readTermListener);
        cbRead.setOnCheckedChangeListener(cbReadCheckedListener);
        btnNext.setOnClickListener(onNext);
        btnCancel.setOnClickListener(onCancel);
    }

    private NestedScrollView.OnScrollChangeListener readTermListener = new NestedScrollView.OnScrollChangeListener() {
        @Override
        public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            if (scrollY == (v.getChildAt(0).getMeasuredHeight()) - v.getMeasuredHeight()){
                cbRead.setEnabled(true);
            }
        }
    };

    private CompoundButton.OnCheckedChangeListener cbReadCheckedListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
            if (checked){
                btnCancel.setEnabled(true);
                btnNext.setEnabled(true);
            } else {
                btnCancel.setEnabled(false);
                btnNext.setEnabled(false);
            }
        }
    };

    private View.OnClickListener onNext = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            read = true;
            instance.dismiss();
        }
    };

    private View.OnClickListener onCancel = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            instance.dismiss();
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home && instance.isVisible()) {
            instance.dismiss();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
