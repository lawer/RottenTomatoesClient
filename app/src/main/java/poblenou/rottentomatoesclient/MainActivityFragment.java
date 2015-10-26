package poblenou.rottentomatoesclient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import poblenou.rottentomatoesclient.json.ApiData;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ListView lvPelis = (ListView) rootView.findViewById(R.id.lvPelis);

        String[] data = {
                "Los 400 golpes",
                "El odio",
                "El padrino",
                "El padrino. Parte II",
                "Ocurrió cerca de su casa",
                "Infiltrados",
                "Umberto D."
        };

        items = new ArrayList<>(Arrays.asList(data));
        adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.lvpelis_row,
                R.id.tvPeli,
                items
        );
        lvPelis.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_pelis_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void refresh() {
        final String BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RottenTomatoesInterface servei = retrofit.create(RottenTomatoesInterface.class);

        Call<ApiData> call = servei.getPeliculesMesVistes("es");
        call.enqueue(new Callback<ApiData>() {
            @Override
            public void onResponse(Response<ApiData> response, Retrofit retrofit) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    public interface RottenTomatoesInterface {
        @GET("lists/movies/box_office.json")
        Call<ApiData> getPeliculesMesVistes(@Query("country") String pais);

        @GET("lists/movies/upcoming.json")
        Call<ApiData> getProximesEstrenes(@Query("country") String pais);
    }

}
