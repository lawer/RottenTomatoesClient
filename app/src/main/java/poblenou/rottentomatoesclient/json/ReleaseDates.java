
package poblenou.rottentomatoesclient.json;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ReleaseDates implements Parcelable {

    public static final Parcelable.Creator<ReleaseDates> CREATOR = new Parcelable.Creator<ReleaseDates>() {
        public ReleaseDates createFromParcel(Parcel source) {
            return new ReleaseDates(source);
        }

        public ReleaseDates[] newArray(int size) {
            return new ReleaseDates[size];
        }
    };
    @SerializedName("theater")
    @Expose
    private String theater;

    public ReleaseDates() {
    }

    protected ReleaseDates(Parcel in) {
        this.theater = in.readString();
    }

    /**
     *
     * @return
     *     The theater
     */
    public String getTheater() {
        return theater;
    }

    /**
     *
     * @param theater
     *     The theater
     */
    public void setTheater(String theater) {
        this.theater = theater;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.theater);
    }
}
