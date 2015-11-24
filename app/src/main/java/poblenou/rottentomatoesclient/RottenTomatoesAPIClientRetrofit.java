package poblenou.rottentomatoesclient;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import poblenou.rottentomatoesclient.json.ApiData;
import poblenou.rottentomatoesclient.json.Movie;
import poblenou.rottentomatoesclient.provider.movies.MoviesColumns;
import poblenou.rottentomatoesclient.provider.movies.MoviesContentValues;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

public class RottenTomatoesAPIClientRetrofit {
    final String BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";
    final String API_KEY = "9htuhtcb4ymusd73d4z6jxcj";
    private final Context context;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    RottenTomatoesInterface servei = retrofit.create(RottenTomatoesInterface.class);

    public RottenTomatoesAPIClientRetrofit(Context context) {
        super();
        this.context = context;
    }

    public void getPelicules(String pais) {
        UpdateMoviesTask updateMovies = new UpdateMoviesTask();
        updateMovies.execute(pais);
    }

    private void deleteOldMovies(long syncTime) {
        context.getContentResolver().delete(
                MoviesColumns.CONTENT_URI,
                MoviesColumns.SYNCTIME + " < ?",
                new String[]{Long.toString(syncTime)});
    }

    private void processCall(Call<ApiData> call, final String movieList, final long syncTime) {
        try {
            Response<ApiData> response = call.execute();

            if (response.isSuccess()) {
                ApiData apiData = response.body();

                for (Movie peli : apiData.getMovies()) {
                    MoviesContentValues values = new MoviesContentValues();

                    values.putTitle(peli.getTitle());
                    values.putAudiencescore(peli.getRatings().getAudienceScore());
                    values.putConsensus(peli.getCriticsConsensus());
                    values.putCriticsscore(peli.getRatings().getCriticsScore());
                    values.putPosterurl(peli.getPoster());
                    values.putReleasedate(peli.getReleaseDates().getTheater());
                    values.putSynopsis(peli.getSynopsis());
                    values.putSynctime(syncTime);
                    values.putMovielist(movieList);

                    context.getContentResolver().insert(
                            MoviesColumns.CONTENT_URI,
                            values.values());

                    Picasso.with(context).load(peli.getPoster()).fetch();
                }
            } else {
                Log.e("XXX", response.errorBody().toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    interface RottenTomatoesInterface {
        @GET("lists/movies/box_office.json")
        Call<ApiData> getPeliculesMesVistes(
                @Query("country") String pais,
                @Query("apikey") String apiKey
        );

        @GET("lists/movies/upcoming.json")
        Call<ApiData> getProximesEstrenes(
                @Query("country") String pais,
                @Query("apikey") String apiKey
        );
    }

    class UpdateMoviesTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            String pais = (String) params[0];

            Call<ApiData> callMesVistes = servei.getPeliculesMesVistes(pais, API_KEY);
            Call<ApiData> callProximesEstrenes = servei.getProximesEstrenes(pais, API_KEY);
            long syncTime = System.currentTimeMillis();

            processCall(callMesVistes, "mes_vistes", syncTime);
            processCall(callProximesEstrenes, "proximes_estrenes", syncTime);

            deleteOldMovies(syncTime);
            return null;
        }
    }

}

