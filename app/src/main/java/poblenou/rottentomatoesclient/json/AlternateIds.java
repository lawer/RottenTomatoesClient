
package poblenou.rottentomatoesclient.json;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class AlternateIds implements Parcelable {

    public static final Parcelable.Creator<AlternateIds> CREATOR = new Parcelable.Creator<AlternateIds>() {
        public AlternateIds createFromParcel(Parcel source) {
            return new AlternateIds(source);
        }

        public AlternateIds[] newArray(int size) {
            return new AlternateIds[size];
        }
    };
    @SerializedName("imdb")
    @Expose
    private String imdb;

    public AlternateIds() {
    }

    protected AlternateIds(Parcel in) {
        this.imdb = in.readString();
    }

    /**
     *
     * @return
     *     The imdb
     */
    public String getImdb() {
        return imdb;
    }

    /**
     *
     * @param imdb
     *     The imdb
     */
    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imdb);
    }
}
