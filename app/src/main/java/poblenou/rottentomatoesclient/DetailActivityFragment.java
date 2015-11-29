package poblenou.rottentomatoesclient;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.florent37.picassopalette.PicassoPalette;
import com.squareup.picasso.Picasso;

import poblenou.rottentomatoesclient.provider.movies.MoviesColumns;
import poblenou.rottentomatoesclient.provider.movies.MoviesCursor;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private ImageView ivPosterImage;
    private TextView tvTitle;
    private TextView tvSynopsis;
    private TextView tvAudienceScore;
    private TextView tvCriticsScore;
    private LinearLayout llTitleScores;
    private RelativeLayout rlContent;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        // Fetch views
        ivPosterImage = (ImageView) view.findViewById(R.id.ivPoster);
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvSynopsis = (TextView) view.findViewById(R.id.tvSynopsis);
        tvAudienceScore = (TextView) view.findViewById(R.id.tvAudienceScore);
        tvCriticsScore = (TextView) view.findViewById(R.id.tvCriticsScore);
        llTitleScores = (LinearLayout) view.findViewById(R.id.llTitleScores);
        rlContent = (RelativeLayout) view.findViewById(R.id.rlContent);

        Long movie_id = getActivity().getIntent().getLongExtra("movie_id", -1);

        if (movie_id != -1) {
            loadMovie(view, movie_id);
        }

        return view;
    }

    private void loadMovie(View view, Long movie_id) {
        // Load movie data
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

        // R.drawable.large_movie_poster from
        // http://content8.flixster.com/movie/11/15/86/11158674_pro.jpg -->
        Picasso.with(getContext())
                .load(moviesCursor.getPosterurl())
                .fit()
                .centerInside()
                .into(ivPosterImage,
                        PicassoPalette.with(moviesCursor.getPosterurl(), ivPosterImage)
                                .use(PicassoPalette.Profile.VIBRANT_DARK)
                                .intoBackground(llTitleScores)
                                .intoBackground(rlContent)
                                .intoTextColor(tvTitle)
                                .intoTextColor(tvAudienceScore)
                                .intoTextColor(tvSynopsis)
                                .intoTextColor(tvCriticsScore)

                                .use(PicassoPalette.Profile.VIBRANT_DARK)
                                .intoBackground(rlContent)
                );
    }

    public void loadMovieFromActivity(Long movie_id) {
        View view = getView();
        loadMovie(view, movie_id);
    }
}
