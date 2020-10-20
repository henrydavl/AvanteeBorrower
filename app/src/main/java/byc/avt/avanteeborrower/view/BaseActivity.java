package byc.avt.avanteeborrower.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import byc.avt.avanteeborrower.helper.utils.StringRes;
import byc.avt.avanteeborrower.usecase.BaseUseCase;

public abstract class BaseActivity<T extends BaseUseCase> extends AppCompatActivity {

    public T useCase;

    protected abstract T initUseCase();

    protected abstract int initLayout();

    protected abstract void onCreated(Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        this.useCase = initUseCase();

        onCreated(savedInstanceState);
    }

    public String stringOf(int resId) {
        return StringRes.of(this, resId);
    }

    public String stringInject(int res, Object... value) {
        return StringRes.inject(this, res, value);
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
