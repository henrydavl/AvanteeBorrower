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
        String BASE_URL = "https://avantee.co.id:8444/api/";
        String IMG_URL = "https://avantee.co.id:8444/assets/images/";
        String BASIC_AUTH = "Basic " + Base64.encodeToString("Av@nte3:p@ssw0rdyangsimpleajalahyah".getBytes(), Base64.NO_WRAP);
        String CONTENT_TYPE = "application/json";
    }

    @Retention(SOURCE)
    @StringDef()
    public @interface Endpoint {
        String SIGN_IN = BaseSetting.BASE_URL + "signin";

    }

    public static final String X_API_KEY =  "G2HN@D4N483RS@MA";

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
