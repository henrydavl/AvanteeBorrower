package byc.avt.avanteeborrower.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import byc.avt.avanteeborrower.usecase.BaseUseCase;

public abstract class BaseFragment<T extends BaseUseCase> extends Fragment {
    protected T useCase;
    private int visibilityCount;

    protected abstract T initUseCase();

    protected abstract int initLayout();

    protected abstract void onCreated(Bundle savedInstanceState, View view);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public int getVisibilityCount() {
        return visibilityCount;
    }

    public boolean isFirstVisible() {
        System.out.println("BaseFragment::" + this.getClass().getSimpleName() + " --> isFirstVisibile --> visibilityCount : " + visibilityCount);
        return visibilityCount == 1;
    }
}
