package poblenou.rottentomatoesclient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.content.CursorLoader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import poblenou.rottentomatoesclient.provider.movies.MoviesColumns;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor> {
    private MoviesCursorAdapter adapter;
    private SwipeRefreshLayout srlRefresh;

    public MainActivityFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();

        getLoaderManager().restartLoader(0, null, this);
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

        GridView lvPelis = (GridView) rootView.findViewById(R.id.gvPelis);

        adapter = new MoviesCursorAdapter(
                getContext(),
                R.layout.lvpelis_item,
                null,
                new String[]{
                        MoviesColumns.POSTERURL,
                        MoviesColumns.TITLE,
                        MoviesColumns.AUDIENCESCORE
                },
                new int[]{
                        R.id.ivPosterSmall,
                        R.id.tvTitle,
                        R.id.tvCriticsScore
                },
                0
        );
        //Inicialitzem el Loader
        getLoaderManager().initLoader(0, null, this);

        lvPelis.setAdapter(adapter);

        lvPelis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getContext(), DetailActivity.class);
                i.putExtra("movie_id", id);
                startActivity(i);
            }
        });

        srlRefresh = (SwipeRefreshLayout) rootView.findViewById(R.id.srlRefresh);
        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

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

        srlRefresh.setRefreshing(true);

        RottenTomatoesAPIClientRetrofit apiClient = new RottenTomatoesAPIClientRetrofit(getContext());
        apiClient.getPelicules(pais);

        srlRefresh.setRefreshing(false);
    }

    @Override
    public android.support.v4.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String tipusConsulta = preferences.getString("tipus_consulta", "vistes");

        if (tipusConsulta.equals("vistes")) {
            return new CursorLoader(getContext(),
                    MoviesColumns.CONTENT_URI, null,
                    MoviesColumns.MOVIELIST + "= ? ", new String[]{"mes_vistes"},
                    null);
        } else {
            return new CursorLoader(getContext(),
                    MoviesColumns.CONTENT_URI, null,
                    MoviesColumns.MOVIELIST + "= ? ", new String[]{"proximes_estrenes"},
                    null);
        }

    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }

    // Container Activity must implement this interface
    public interface OnMovieSelectedListener {
        public void onMovieSelected(int id);
    }

}
