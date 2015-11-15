
package poblenou.rottentomatoesclient.json;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Movie implements Parcelable {

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("mpaa_rating")
    @Expose
    private String mpaaRating;
    @SerializedName("runtime")
    @Expose
    private String runtime;
    @SerializedName("critics_consensus")
    @Expose
    private String criticsConsensus;
    @SerializedName("release_dates")
    @Expose
    private ReleaseDates releaseDates;
    @SerializedName("ratings")
    @Expose
    private Ratings ratings;
    @SerializedName("synopsis")
    @Expose
    private String synopsis;
    @SerializedName("posters")
    @Expose
    private Posters posters;
    //@SerializedName("abridged_cast")
    //@Expose
    //private List<AbridgedCast> abridgedCast = new ArrayList<AbridgedCast>();
    @SerializedName("alternate_ids")
    @Expose
    private AlternateIds alternateIds;
    @SerializedName("links")
    @Expose
    private Links links;

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.year = (Integer) in.readValue(Integer.class.getClassLoader());
        this.mpaaRating = in.readString();
        this.runtime = in.readString();
        this.criticsConsensus = in.readString();
        this.releaseDates = in.readParcelable(ReleaseDates.class.getClassLoader());
        this.ratings = in.readParcelable(Ratings.class.getClassLoader());
        this.synopsis = in.readString();
        this.posters = in.readParcelable(Posters.class.getClassLoader());
        //this.abridgedCast = new ArrayList<AbridgedCast>();
        //in.readList(this.abridgedCast, List.class.getClassLoader());
        this.alternateIds = in.readParcelable(AlternateIds.class.getClassLoader());
        this.links = in.readParcelable(Links.class.getClassLoader());
    }

    /**
     *
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     *     The year
     */
    public Integer getYear() {
        return year;
    }

    /**
     *
     * @param year
     *     The year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     *
     * @return
     *     The mpaaRating
     */
    public String getMpaaRating() {
        return mpaaRating;
    }

    /**
     *
     * @param mpaaRating
     *     The mpaa_rating
     */
    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    /**
     *
     * @return
     *     The runtime
     */
    public String getRuntime() {
        return runtime;
    }

    /**
     *
     * @param runtime
     *     The runtime
     */
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    /**
     *
     * @return
     *     The criticsConsensus
     */
    public String getCriticsConsensus() {
        return criticsConsensus;
    }

    /**
     *
     * @param criticsConsensus
     *     The critics_consensus
     */
    public void setCriticsConsensus(String criticsConsensus) {
        this.criticsConsensus = criticsConsensus;
    }

    /**
     *
     * @return
     *     The releaseDates
     */
    public ReleaseDates getReleaseDates() {
        return releaseDates;
    }

    /**
     *
     * @param releaseDates
     *     The release_dates
     */
    public void setReleaseDates(ReleaseDates releaseDates) {
        this.releaseDates = releaseDates;
    }

    /**
     *
     * @return
     *     The ratings
     */
    public Ratings getRatings() {
        return ratings;
    }

    /**
     *
     * @param ratings
     *     The ratings
     */
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    /**
     *
     * @return
     *     The synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     *
     * @param synopsis
     *     The synopsis
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     *
     * @return
     *     The posters
     */
    public Posters getPosters() {
        return posters;
    }

    /**
     *
     * @param posters
     *     The posters
     */
    public void setPosters(Posters posters) {
        this.posters = posters;
    }

    /**
     *
     * @return
     *     The abridgedCast
     */
    /*public List<AbridgedCast> getAbridgedCast() {
        return abridgedCast;
    }*/

    /**
     *
     * @param abridgedCast
     *     The abridged_cast
     */
    /*public void setAbridgedCast(List<AbridgedCast> abridgedCast) {
        this.abridgedCast = abridgedCast;
    }*/

    /**
     *
     * @return
     *     The alternateIds
     */
    public AlternateIds getAlternateIds() {
        return alternateIds;
    }

    /**
     *
     * @param alternateIds
     *     The alternate_ids
     */
    public void setAlternateIds(AlternateIds alternateIds) {
        this.alternateIds = alternateIds;
    }

    /**
     *
     * @return
     *     The links
     */
    public Links getLinks() {
        return links;
    }

    /**
     *
     * @param links
     *     The links
     */
    public void setLinks(Links links) {
        this.links = links;
    }

    /*public String getCast() {
        StringBuilder builder = new StringBuilder();
        for (AbridgedCast actor : abridgedCast) {
            builder.append(actor.getName());
            builder.append(", ");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }*/

    public String getPoster() {
        String chunga = getPosters().getOriginal();
        String original = chunga.replaceAll("^.*?\\/[\\d]+x[\\d]+\\/", "http://");

        return original;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", mpaaRating='" + mpaaRating + '\'' +
                ", runtime=" + runtime +
                ", criticsConsensus='" + criticsConsensus + '\'' +
                ", releaseDates=" + releaseDates +
                ", ratings=" + ratings +
                ", synopsis='" + synopsis + '\'' +
                ", posters=" + posters +
                //", abridgedCast=" + abridgedCast +
                ", alternateIds=" + alternateIds +
                ", links=" + links +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeValue(this.year);
        dest.writeString(this.mpaaRating);
        dest.writeString(this.runtime);
        dest.writeString(this.criticsConsensus);
        dest.writeParcelable(this.releaseDates, flags);
        dest.writeParcelable(this.ratings, flags);
        dest.writeString(this.synopsis);
        dest.writeParcelable(this.posters, flags);
        //dest.writeList(this.abridgedCast);
        dest.writeParcelable(this.alternateIds, flags);
        dest.writeParcelable(this.links, flags);
    }
}
