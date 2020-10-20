package byc.avt.avanteeborrower.helper.utils;

import byc.avt.avanteeborrower.view.BaseActivity;

public class StringRes {

    public static String of(BaseActivity activity, int resId) {
        return activity.getResources().getString(resId);
    }

    public static String inject(BaseActivity activity, int res, Object... value) {
        return String.format(activity.getResources().getString(res), value);
    }
}
