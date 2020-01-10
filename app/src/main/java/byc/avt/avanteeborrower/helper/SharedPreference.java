package byc.avt.avanteeborrower.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    private static final String PREF = "user";
    private Context context;
    private SharedPreferences sharedPreferences;
    private String idKey = "idKey";
    private String nameKey = "nameKey";
    private String emailKey = "nameKey";
    private String onBoarding = "onBoarding";

    public SharedPreference(Context context) {
        this.context = context;
    }

    public String getIdKey() {
        return idKey;
    }

    public void setIdKey(String idKey) {
        this.idKey = idKey;
    }

    public String getNameKey() {
        return nameKey;
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    public String getEmailKey() {
        return emailKey;
    }

    public void setEmailKey(String emailKey) {
        this.emailKey = emailKey;
    }

    public String getOnBoarding() {
        return onBoarding;
    }

    public void setOnBoarding(String onBoarding) {
        this.onBoarding = onBoarding;
    }
}
