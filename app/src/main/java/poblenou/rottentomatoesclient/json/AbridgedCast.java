
package poblenou.rottentomatoesclient.json;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class AbridgedCast implements Parcelable {

    public static final Parcelable.Creator<AbridgedCast> CREATOR = new Parcelable.Creator<AbridgedCast>() {
        public AbridgedCast createFromParcel(Parcel source) {
            return new AbridgedCast(source);
        }

        public AbridgedCast[] newArray(int size) {
            return new AbridgedCast[size];
        }
    };
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("characters")
    @Expose
    private List<String> characters = new ArrayList<String>();

    public AbridgedCast() {
    }

    protected AbridgedCast(Parcel in) {
        this.name = in.readString();
        this.id = in.readString();
        this.characters = in.createStringArrayList();
    }

    /**
     *
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
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
     *     The characters
     */
    public List<String> getCharacters() {
        return characters;
    }

    /**
     *
     * @param characters
     *     The characters
     */
    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.id);
        dest.writeStringList(this.characters);
    }
}
