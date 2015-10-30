package poblenou.rottentomatoesclient;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import poblenou.rottentomatoesclient.json.Movie;

public class MoviesAdapter extends ArrayAdapter<Movie> {

    public MoviesAdapter(Context context, int resource, List<Movie> objects) {
        super(context, resource, objects);
    }
}
