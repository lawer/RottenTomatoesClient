
package poblenou.rottentomatoesclient.json;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Ratings {

    private String criticsRating;
    private Integer criticsScore;
    private Integer audienceScore;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
