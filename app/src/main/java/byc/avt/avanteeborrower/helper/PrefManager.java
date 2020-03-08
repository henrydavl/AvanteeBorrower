package byc.avt.avanteeborrower.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    private static final String PREF = "user";
    private Context context;
    private SharedPreferences sharedPreferences;
    private String idKey = "idKey";
    private String nameKey = "nameKey";
    private String emailKey = "nameKey";
    private String onBoarding = "onBoarding";

    public PrefManager(Context context) {
        this.context = context;
    }

    public void setOnBoarding(Boolean value) {
        sharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(onBoarding, value);
        editor.apply();
    }

    public boolean getOnBoarding(){
        sharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(onBoarding, false);
    }
}
