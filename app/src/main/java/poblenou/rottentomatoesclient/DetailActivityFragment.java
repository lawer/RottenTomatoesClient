package poblenou.rottentomatoesclient;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import poblenou.rottentomatoesclient.provider.movies.MoviesColumns;
import poblenou.rottentomatoesclient.provider.movies.MoviesCursor;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        super.onCreate(savedInstanceState);
        // Fetch views
        ImageView ivPosterImage = (ImageView) view.findViewById(R.id.ivPoster);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        TextView tvSynopsis = (TextView) view.findViewById(R.id.tvSynopsis);
        TextView tvCriticsConsensus = (TextView) view.findViewById(R.id.tvCriticsConsensus);
        TextView tvAudienceScore = (TextView) view.findViewById(R.id.tvAudienceScore);
        TextView tvCriticsScore = (TextView) view.findViewById(R.id.tvCriticsScore);

        // Load movie data
        Long movie_id = getActivity().getIntent().getLongExtra("movie_id", -1);
        Cursor cursor = getContext().getContentResolver().query(
                MoviesColumns.CONTENT_URI,
                null,
                MoviesColumns._ID + " = ?",
                new String[]{String.valueOf(movie_id)},
                null
        );

        MoviesCursor moviesCursor = new MoviesCursor(cursor);
        moviesCursor.moveToNext();

        tvTitle.setText(moviesCursor.getTitle());
        tvCriticsScore.setText(
                Html.fromHtml("<b>Critics Score:</b> " +
                        moviesCursor.getCriticsscore() + "%")
        );
        tvAudienceScore.setText(
                Html.fromHtml("<b>Audience Score:</b> " +
                        moviesCursor.getAudiencescore() + "%")
        );
        //tvCast.setText(movie.getCastList());
        tvSynopsis.setText(Html.fromHtml("<b>Synopsis:</b> " + moviesCursor.getSynopsis()));
        tvCriticsConsensus.setText(Html.fromHtml("<b>Consensus:</b> " + moviesCursor.getConsensus()));
        // R.drawable.large_movie_poster from
        // http://content8.flixster.com/movie/11/15/86/11158674_pro.jpg -->
        Picasso.with(getContext())
                .load(moviesCursor.getPosterurl()).
                into(ivPosterImage);


        return view;
    }
}
