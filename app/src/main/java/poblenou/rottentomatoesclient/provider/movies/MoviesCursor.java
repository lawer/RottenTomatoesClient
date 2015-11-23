package poblenou.rottentomatoesclient.provider.movies;

import android.database.Cursor;
import android.support.annotation.Nullable;

import java.util.Date;

import poblenou.rottentomatoesclient.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code movies} table.
 */
public class MoviesCursor extends AbstractCursor implements MoviesModel {
    public MoviesCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(MoviesColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getTitle() {
        String res = getStringOrNull(MoviesColumns.TITLE);
        return res;
    }

    /**
     * Get the {@code criticsscore} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getCriticsscore() {
        Integer res = getIntegerOrNull(MoviesColumns.CRITICSSCORE);
        return res;
    }

    /**
     * Get the {@code audiencescore} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getAudiencescore() {
        Integer res = getIntegerOrNull(MoviesColumns.AUDIENCESCORE);
        return res;
    }

    /**
     * Get the {@code consensus} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getConsensus() {
        String res = getStringOrNull(MoviesColumns.CONSENSUS);
        return res;
    }

    /**
     * Get the {@code synopsis} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getSynopsis() {
        String res = getStringOrNull(MoviesColumns.SYNOPSIS);
        return res;
    }

    /**
     * Get the {@code releasedate} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getReleasedate() {
        String res = getStringOrNull(MoviesColumns.RELEASEDATE);
        return res;
    }

    /**
     * Get the {@code posterurl} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPosterurl() {
        String res = getStringOrNull(MoviesColumns.POSTERURL);
        return res;
    }

    /**
     * Get the {@code synctime} value.
     * Can be {@code null}.
     */
    @Nullable
    public Date getSynctime() {
        Date res = getDateOrNull(MoviesColumns.SYNCTIME);
        return res;
    }

    /**
     * Get the {@code movielist} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMovielist() {
        String res = getStringOrNull(MoviesColumns.MOVIELIST);
        return res;
    }
}
