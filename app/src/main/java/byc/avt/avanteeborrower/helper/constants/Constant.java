package byc.avt.avanteeborrower.helper.constants;

import android.util.Base64;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class Constant {

    public static final String BASE_URL = "https://avantee.co.id:8444/baycode_api/";
    public static final String IMG_URL = "https://avantee.co.id:8444/assets/images/";
    public static final String basicAuth = "Basic " + Base64.encodeToString("Av@nTe3:p@ssw0rdyangsimpleajalahyah".getBytes(), Base64.NO_WRAP);
    public static final String X_API_KEY =  "G2HN@D4N483RS@MA";
    public static final String TYPE = "application/json";

    public static final Map<String, String> API_ACCESS(){
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type: ", TYPE);
        header.put("Accept: ", TYPE);
        header.put("Authorization", basicAuth);
        header.put("X-API-KEY", X_API_KEY);
        return header;
    }

//    public static final Pattern PASSWORD_PATTERN = Pattern.compile(
//
//    );
}
