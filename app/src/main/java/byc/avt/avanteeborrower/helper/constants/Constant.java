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
        String DOCUMENT = BaseSetting.BASE_URL + "borrower/document";
    }

//    public static final Map<String, String> API_ACCESS(){
//        Map<String, String> header = new HashMap<>();
//        header.put("Content-Type: ", TYPE);
//        header.put("Accept: ", TYPE);
//        header.put("Authorization", basicAuth);
//        header.put("X-API-KEY", X_API_KEY);
//        return header;
//    }

//    public static final Pattern PASSWORD_PATTERN = Pattern.compile(
//
//    );
}
