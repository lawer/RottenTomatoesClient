package poblenou.rottentomatoesclient;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import poblenou.rottentomatoesclient.provider.movies.MoviesCursor;

public class MoviesCursorAdapter extends SimpleCursorAdapter {


    private final Context context;

    public MoviesCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Obtenim l'objecte en la posició corresponent
        Cursor cursor = getCursor();
        MoviesCursor moviesCursor = new MoviesCursor(cursor);
        moviesCursor.moveToPosition(position);

        // Mirem a veure si la View s'està reusant, si no es així "inflem" la View
        // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView#row-view-recycling
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.lvpelis_item, parent, false);
        }

        // Unim el codi en les Views del Layout
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvReleaseDate = (TextView) convertView.findViewById(R.id.tvReleaseDate);
        //TextView tvCast = (TextView) convertView.findViewById(R.id.tvCast);
        ImageView ivPosterImage = (ImageView) convertView.findViewById(R.id.ivPosterSmall);

        // Fiquem les dades dels objectes (provinents del JSON) en el layout
        tvTitle.setText(moviesCursor.getTitle());
        tvReleaseDate.setText("Release Date: " + moviesCursor.getReleasedate());
        Picasso.with(context).load(moviesCursor.getPosterurl()).fit().into(ivPosterImage);

        // Retornem la View replena per a mostrarla
        return convertView;
    }

}
