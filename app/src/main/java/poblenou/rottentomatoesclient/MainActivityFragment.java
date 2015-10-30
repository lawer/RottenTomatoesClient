package poblenou.rottentomatoesclient;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

import poblenou.rottentomatoesclient.json.Movie;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private ArrayList<Movie> items;
    private ArrayAdapter<Movie> adapter;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ListView lvPelis = (ListView) rootView.findViewById(R.id.lvPelis);

        items = new ArrayList<>();
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
        String pais = "es";

        RottenTomatoesAPIClientRetrofit apiClient = new RottenTomatoesAPIClientRetrofit();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String tipusConsulta = preferences.getString("tipus_consulta", "vistes");

        if (tipusConsulta.equals("vistes")) {
            apiClient.getPeliculesMesVistes(adapter, pais);
        } else {
            apiClient.getProximesEstrenes(adapter, pais);
        }
    }
}
