package byc.avt.avanteeborrower.helper.constants;

import android.util.Base64;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static java.lang.annotation.RetentionPolicy.*;

public class Constant {

    @Retention(SOURCE)
    @StringDef()
    public @interface BaseSetting {
        String BASE_URL = "https://avantee.co.id:8444/api/internal/";
        String IMG_URL = "https://avantee.co.id:8444/assets/images/";
        String BASIC_AUTH = "Basic " + Base64.encodeToString("B@code3:p@ssw0rdyangsimpleajalahyah".getBytes(), Base64.NO_WRAP);
        String CONTENT_TYPE = "application/json";
    }

    @Retention(SOURCE)
    @StringDef()
    public @interface Endpoint {
        /* TODO: Universal endpoint */
        String SIGN_IN = "signin";
        String REGISTER = "auth/register";

        /* TODO: Master data endpoint */
        String COUNTRY = "country";
        String PROVINCE = "Province";
        String CITY = "city/{province_id}";
        String BANK = "bank";
        String MARITAL_STATUS = "status";
        String RELIGION = "religion";
        String LAST_EDUCATION = "education";
        String JOB_TITLE = "job";
        String EXPERIENCE = "experience";

        /* TODO: Borrower endpoint */
        String DASHBOARD = "borrower/dashboard";
        String DOCUMENT = "borrower/document";
    }

    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^" +
            "(?=.*[0-9])" +         //at least has 1 number
            "(?=.*[a-z])" +         //at least has 1 lower case letter
            "(?=.*[A-Z])" +         //at least has 1 upper case letter
            "(?=\\S+$)." + //no white spaces
            "{8,12}" + //at least 8 character, max 12 character
            "$");
}
