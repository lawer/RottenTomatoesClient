
package poblenou.rottentomatoesclient.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ApiData {

    private List<Movie> movies = new ArrayList<Movie>();
    private Links_ links;
    private String linkTemplate;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * @param movies The movies
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * @return The links
     */
    public Links_ getLinks() {
        return links;
    }

    /**
     * @param links The links
     */
    public void setLinks(Links_ links) {
        this.links = links;
    }

    /**
     * @return The linkTemplate
     */
    public String getLinkTemplate() {
        return linkTemplate;
    }

    /**
     * @param linkTemplate The link_template
     */
    public void setLinkTemplate(String linkTemplate) {
        this.linkTemplate = linkTemplate;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
