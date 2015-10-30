package poblenou.rottentomatoesclient;

import android.util.Log;
import android.widget.ArrayAdapter;

import poblenou.rottentomatoesclient.json.ApiData;
import poblenou.rottentomatoesclient.json.Movie;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

public class RottenTomatoesAPIClientRetrofit {
    final String BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";
    final String API_KEY = "9htuhtcb4ymusd73d4z6jxcj";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    RottenTomatoesInterface servei = retrofit.create(RottenTomatoesInterface.class);

    public RottenTomatoesAPIClientRetrofit() {
        super();
    }

    public void getPeliculesMesVistes(final ArrayAdapter<Movie> adapter, String pais) {
        Call<ApiData> call = servei.getPeliculesMesVistes(pais, API_KEY);
        processCall(adapter, call);
    }

    public void getProximesEstrenes(final ArrayAdapter<Movie> adapter, String pais) {
        Call<ApiData> call = servei.getProximesEstrenes(pais, API_KEY);
        processCall(adapter, call);
    }


    private void processCall(final ArrayAdapter<Movie> adapter, Call<ApiData> call) {
        call.enqueue(new Callback<ApiData>() {
                         @Override
                         public void onResponse(Response<ApiData> response, Retrofit retrofit) {
                             if (response.isSuccess()) {
                                 ApiData apiData = response.body();

                                 adapter.clear();
                                 for (Movie peli : apiData.getMovies()) {
                                     adapter.add(peli);
                                 }
                             } else {
                                 Log.e("XXX", response.errorBody().toString());
                             }
                         }

                         @Override
                         public void onFailure(Throwable t) {
                             t.printStackTrace();
                         }
                     }

        );
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

}

