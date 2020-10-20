package byc.avt.avanteeborrower.model;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("code")
    private String code;

    @SerializedName("status")
    private Boolean status;

    @SerializedName("token")
    private String token;

    @SerializedName("result")
    private UserSession result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserSession getResult() {
        return result;
    }

    public void setResult(UserSession result) {
        this.result = result;
    }
}
