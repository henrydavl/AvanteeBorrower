package byc.avt.avanteeborrower.view.registration.forms;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.view.settings.account.SettingAccountActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DocumentFragment extends Fragment {

    private Button next;
    private ImageView ivInfo;

    public DocumentFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_document, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivInfo = view.findViewById(R.id.img_info_take_bank_book_fr_document);

        ivInfo.setOnClickListener(this::openSheet);
    }

    private void openSheet(View view){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireActivity(), R.style.BottomSheetDialogTheme);
        View bottomSheetView = LayoutInflater.from(requireActivity()
                .getApplicationContext())
                .inflate(R.layout.sheet_bank_photo_guide, view.findViewById(R.id.btSheet_bankPicGuide));
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
}
