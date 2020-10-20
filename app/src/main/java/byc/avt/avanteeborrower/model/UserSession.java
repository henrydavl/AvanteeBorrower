package byc.avt.avanteeborrower.model;

import com.google.gson.annotations.SerializedName;

public class UserSession {

    @SerializedName("uid")
    private String uid;

    @SerializedName("type")
    private int type;

    @SerializedName("client_type")
    private String clientType;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("name")
    private String name;

    @SerializedName("avantee_verif")
    private int verified;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }
}
