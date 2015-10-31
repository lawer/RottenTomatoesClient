package poblenou.rottentomatoesclient;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import poblenou.rottentomatoesclient.json.Movie;

public class MoviesAdapter extends ArrayAdapter<Movie> {

    public MoviesAdapter(Context context, int resource, List<Movie> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Obtenim l'objecte en la posició corresponent
        Movie movie = getItem(position);
        //Log.w("XXXX", movie.toString());

        // Mirem a veure si la View s'està reusant, si no es així "inflem" la View
        // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView#row-view-recycling
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lvpelis_row, parent, false);
        }

        // Unim el codi en les Views del Layout
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvCriticsScore = (TextView) convertView.findViewById(R.id.tvCriticsScore);
        TextView tvCast = (TextView) convertView.findViewById(R.id.tvCast);
        ImageView ivPosterImage = (ImageView) convertView.findViewById(R.id.ivPosterImage);

        // Fiquem les dades dels objectes (provinents del JSON) en el layout
        tvTitle.setText(movie.getTitle());
        tvCriticsScore.setText("Score: " + movie.getRatings().getCriticsScore() + "%");
        tvCast.setText(movie.getCast());

        Log.w("XXXX", movie.getPoster());

        Picasso.with(getContext()).load(movie.getPoster()).resize(120, 0).into(ivPosterImage);

        // Retornem la View replena per a mostrarla
        return convertView;
    }

}
