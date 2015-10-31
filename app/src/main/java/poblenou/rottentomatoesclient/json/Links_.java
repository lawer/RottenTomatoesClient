
package poblenou.rottentomatoesclient.json;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Links_ implements Parcelable {

    public static final Parcelable.Creator<Links_> CREATOR = new Parcelable.Creator<Links_>() {
        public Links_ createFromParcel(Parcel source) {
            return new Links_(source);
        }

        public Links_[] newArray(int size) {
            return new Links_[size];
        }
    };
    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("alternate")
    @Expose
    private String alternate;

    public Links_() {
    }

    protected Links_(Parcel in) {
        this.self = in.readString();
        this.alternate = in.readString();
    }

    /**
     *
     * @return
     *     The self
     */
    public String getSelf() {
        return self;
    }

    /**
     *
     * @param self
     *     The self
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     *
     * @return
     *     The alternate
     */
    public String getAlternate() {
        return alternate;
    }

    /**
     *
     * @param alternate
     *     The alternate
     */
    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.self);
        dest.writeString(this.alternate);
    }
}
