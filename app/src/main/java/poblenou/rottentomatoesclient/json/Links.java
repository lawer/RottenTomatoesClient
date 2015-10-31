
package poblenou.rottentomatoesclient.json;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Links implements Parcelable {

    public static final Parcelable.Creator<Links> CREATOR = new Parcelable.Creator<Links>() {
        public Links createFromParcel(Parcel source) {
            return new Links(source);
        }

        public Links[] newArray(int size) {
            return new Links[size];
        }
    };
    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("alternate")
    @Expose
    private String alternate;
    @SerializedName("cast")
    @Expose
    private String cast;
    @SerializedName("reviews")
    @Expose
    private String reviews;
    @SerializedName("similar")
    @Expose
    private String similar;

    public Links() {
    }

    protected Links(Parcel in) {
        this.self = in.readString();
        this.alternate = in.readString();
        this.cast = in.readString();
        this.reviews = in.readString();
        this.similar = in.readString();
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

    /**
     *
     * @return
     *     The cast
     */
    public String getCast() {
        return cast;
    }

    /**
     *
     * @param cast
     *     The cast
     */
    public void setCast(String cast) {
        this.cast = cast;
    }

    /**
     *
     * @return
     *     The reviews
     */
    public String getReviews() {
        return reviews;
    }

    /**
     *
     * @param reviews
     *     The reviews
     */
    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    /**
     *
     * @return
     *     The similar
     */
    public String getSimilar() {
        return similar;
    }

    /**
     *
     * @param similar
     *     The similar
     */
    public void setSimilar(String similar) {
        this.similar = similar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.self);
        dest.writeString(this.alternate);
        dest.writeString(this.cast);
        dest.writeString(this.reviews);
        dest.writeString(this.similar);
    }
}
