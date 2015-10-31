
package poblenou.rottentomatoesclient.json;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Ratings implements Parcelable {

    public static final Parcelable.Creator<Ratings> CREATOR = new Parcelable.Creator<Ratings>() {
        public Ratings createFromParcel(Parcel source) {
            return new Ratings(source);
        }

        public Ratings[] newArray(int size) {
            return new Ratings[size];
        }
    };
    @SerializedName("critics_rating")
    @Expose
    private String criticsRating;
    @SerializedName("critics_score")
    @Expose
    private Integer criticsScore;
    @SerializedName("audience_rating")
    @Expose
    private String audienceRating;
    @SerializedName("audience_score")
    @Expose
    private Integer audienceScore;

    public Ratings() {
    }

    protected Ratings(Parcel in) {
        this.criticsRating = in.readString();
        this.criticsScore = (Integer) in.readValue(Integer.class.getClassLoader());
        this.audienceRating = in.readString();
        this.audienceScore = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    /**
     *
     * @return
     *     The criticsRating
     */
    public String getCriticsRating() {
        return criticsRating;
    }

    /**
     *
     * @param criticsRating
     *     The critics_rating
     */
    public void setCriticsRating(String criticsRating) {
        this.criticsRating = criticsRating;
    }

    /**
     *
     * @return
     *     The criticsScore
     */
    public Integer getCriticsScore() {
        return criticsScore;
    }

    /**
     *
     * @param criticsScore
     *     The critics_score
     */
    public void setCriticsScore(Integer criticsScore) {
        this.criticsScore = criticsScore;
    }

    /**
     *
     * @return
     *     The audienceRating
     */
    public String getAudienceRating() {
        return audienceRating;
    }

    /**
     *
     * @param audienceRating
     *     The audience_rating
     */
    public void setAudienceRating(String audienceRating) {
        this.audienceRating = audienceRating;
    }

    /**
     *
     * @return
     *     The audienceScore
     */
    public Integer getAudienceScore() {
        return audienceScore;
    }

    /**
     *
     * @param audienceScore
     *     The audience_score
     */
    public void setAudienceScore(Integer audienceScore) {
        this.audienceScore = audienceScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.criticsRating);
        dest.writeValue(this.criticsScore);
        dest.writeString(this.audienceRating);
        dest.writeValue(this.audienceScore);
    }
}
