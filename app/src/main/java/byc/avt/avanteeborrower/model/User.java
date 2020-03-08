package byc.avt.avanteeborrower.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String phoneNumber, email, password, ref_code;
    private int user_id;

    public User() {

    }

    public String getRef_code() {
        return ref_code;
    }

    public void setRef_code(String ref_code) {
        this.ref_code = ref_code;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.phoneNumber);
        dest.writeString(this.email);
        dest.writeString(this.password);
        dest.writeString(this.ref_code);
        dest.writeInt(this.user_id);
    }

    protected User(Parcel in) {
        this.phoneNumber = in.readString();
        this.email = in.readString();
        this.password = in.readString();
        this.ref_code = in.readString();
        this.user_id = in.readInt();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
