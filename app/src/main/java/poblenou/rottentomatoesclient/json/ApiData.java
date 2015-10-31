
package poblenou.rottentomatoesclient.json;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ApiData implements Parcelable {

    public static final Parcelable.Creator<ApiData> CREATOR = new Parcelable.Creator<ApiData>() {
        public ApiData createFromParcel(Parcel source) {
            return new ApiData(source);
        }

        public ApiData[] newArray(int size) {
            return new ApiData[size];
        }
    };
    @SerializedName("movies")
    @Expose
    private List<Movie> movies = new ArrayList<Movie>();
    @SerializedName("links")
    @Expose
    private Links_ links;
    @SerializedName("link_template")
    @Expose
    private String linkTemplate;

    public ApiData() {
    }

    protected ApiData(Parcel in) {
        this.movies = in.createTypedArrayList(Movie.CREATOR);
        this.links = in.readParcelable(Links_.class.getClassLoader());
        this.linkTemplate = in.readString();
    }

    /**
     *
     * @return
     *     The movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     *
     * @param movies
     *     The movies
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    /**
     *
     * @return
     *     The links
     */
    public Links_ getLinks() {
        return links;
    }

    /**
     *
     * @param links
     *     The links
     */
    public void setLinks(Links_ links) {
        this.links = links;
    }

    /**
     *
     * @return
     *     The linkTemplate
     */
    public String getLinkTemplate() {
        return linkTemplate;
    }

    /**
     *
     * @param linkTemplate
     *     The link_template
     */
    public void setLinkTemplate(String linkTemplate) {
        this.linkTemplate = linkTemplate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(movies);
        dest.writeParcelable(this.links, flags);
        dest.writeString(this.linkTemplate);
    }
}
