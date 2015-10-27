package poblenou.rottentomatoesclient;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import poblenou.rottentomatoesclient.json.ApiData;
import poblenou.rottentomatoesclient.json.Movie;

public class RottenTomatoesAPIClientSimple {
    final String BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";
    final String API_KEY = "9htuhtcb4ymusd73d4z6jxcj";

    public RottenTomatoesAPIClientSimple() {
        super();
    }

    public void getPeliculesMesVistes(final ArrayAdapter adapter) {
        final String SUB_URL = "lists/movies/box_office.json";

        final String COUNTRY_PARAM = "country";
        final String APIKEY_PARAM = "apikey";

        String country = "es";

        Uri builtUri = Uri.parse(BASE_URL + SUB_URL).buildUpon()
                .appendQueryParameter(COUNTRY_PARAM, country)
                .appendQueryParameter(APIKEY_PARAM, API_KEY)
                .build();

        Log.w(null, builtUri.toString());

        try {
            URL url = new URL(builtUri.toString());

            DownloadMoviesTask task = new DownloadMoviesTask();
            task.execute(adapter, url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void getProximesEstrenes(final ArrayAdapter adapter) {
        final String SUB_URL = "lists/movies/upcoming.json";

        final String COUNTRY_PARAM = "country";
        final String APIKEY_PARAM = "apikey";

        String country = "es";

        Uri builtUri = Uri.parse(BASE_URL + SUB_URL).buildUpon()
                .appendQueryParameter(COUNTRY_PARAM, country)
                .appendQueryParameter(APIKEY_PARAM, API_KEY)
                .build();

        Log.w("XXXX", builtUri.toString());

        try {
            URL url = new URL(builtUri.toString());

            DownloadMoviesTask task = new DownloadMoviesTask();
            task.execute(adapter, url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public class DownloadMoviesTask extends AsyncTask<Object, Void, ArrayList<String>> {

        private ArrayAdapter<String> adapter;

        @Override
        protected ArrayList<String> doInBackground(Object... params) {
            adapter = (ArrayAdapter<String>) params[0];
            URL url = (URL) params[1];

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            ArrayList<String> movieTitles = new ArrayList<>();
            try {
                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                Gson gson = new Gson();
                ApiData apiData = gson.fromJson(reader, ApiData.class);

                List<Movie> movies = apiData.getMovies();

                for (Movie movie : movies) {
                    movieTitles.add(movie.getTitle());
                }

            } catch (IOException e) {
                Log.e(null, "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attempting
                // to parse it.
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(null, "Error closing stream", e);
                    }
                }
            }
            return movieTitles;
        }


        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(ArrayList<String> forecasts) {
            super.onPostExecute(forecasts);

            adapter.clear();
            adapter.addAll(forecasts);
        }

    }

}

