package poblenou.rottentomatoesclient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import poblenou.rottentomatoesclient.json.Movie;

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
        //TextView tvCast = (TextView) view.findViewById(R.id.tvCast);
        TextView tvCriticsConsensus = (TextView) view.findViewById(R.id.tvCriticsConsensus);
        TextView tvAudienceScore = (TextView) view.findViewById(R.id.tvAudienceScore);
        TextView tvCriticsScore = (TextView) view.findViewById(R.id.tvCriticsScore);
        // Load movie data
       Movie movie = (Movie) getActivity().getIntent().getParcelableExtra("movie");

        tvTitle.setText(movie.getTitle());
        tvCriticsScore.setText(
                Html.fromHtml("<b>Critics Score:</b> " +
                movie.getRatings().getCriticsScore() + "%")
        );
        tvAudienceScore.setText(
                Html.fromHtml("<b>Audience Score:</b> " +
                        movie.getRatings().getAudienceScore() + "%")
        );
        //tvCast.setText(movie.getCastList());
        tvSynopsis.setText(Html.fromHtml("<b>Synopsis:</b> " + movie.getSynopsis()));
        tvCriticsConsensus.setText(Html.fromHtml("<b>Consensus:</b> " + movie.getCriticsConsensus()));
        // R.drawable.large_movie_poster from
        // http://content8.flixster.com/movie/11/15/86/11158674_pro.jpg -->
        Picasso.with(getContext())
                .load(movie.getPoster()).
                into(ivPosterImage);


        return view;
    }
}
