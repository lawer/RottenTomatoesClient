
package poblenou.rottentomatoesclient.json;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ReleaseDates {

    @SerializedName("theater")
    @Expose
    private String theater;

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

}
