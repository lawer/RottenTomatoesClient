
package poblenou.rottentomatoesclient.json;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Posters implements Parcelable {

    public static final Parcelable.Creator<Posters> CREATOR = new Parcelable.Creator<Posters>() {
        public Posters createFromParcel(Parcel source) {
            return new Posters(source);
        }

        public Posters[] newArray(int size) {
            return new Posters[size];
        }
    };
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("profile")
    @Expose
    private String profile;
    @SerializedName("detailed")
    @Expose
    private String detailed;
    @SerializedName("original")
    @Expose
    private String original;

    public Posters() {
    }

    protected Posters(Parcel in) {
        this.thumbnail = in.readString();
        this.profile = in.readString();
        this.detailed = in.readString();
        this.original = in.readString();
    }

    /**
     *
     * @return
     *     The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     *
     * @param thumbnail
     *     The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     *
     * @return
     *     The profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     *
     * @param profile
     *     The profile
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     *
     * @return
     *     The detailed
     */
    public String getDetailed() {
        return detailed;
    }

    /**
     *
     * @param detailed
     *     The detailed
     */
    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    /**
     *
     * @return
     *     The original
     */
    public String getOriginal() {
        return original;
    }

    /**
     *
     * @param original
     *     The original
     */
    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return "Posters{" +
                "thumbnail='" + thumbnail + '\'' +
                ", profile='" + profile + '\'' +
                ", detailed='" + detailed + '\'' +
                ", original='" + original + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.thumbnail);
        dest.writeString(this.profile);
        dest.writeString(this.detailed);
        dest.writeString(this.original);
    }
}
