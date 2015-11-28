package poblenou.rottentomatoesclient;

import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;

/**
 * Created by carlesgm on 28/11/15.
 */
public class UpdateMoviesService extends GcmTaskService {
    @Override
    public int onRunTask(TaskParams taskParams) {
        String pais = "es";

        RottenTomatoesAPIClientRetrofit apiClient = new RottenTomatoesAPIClientRetrofit(this);
        apiClient.getPelicules(pais);

        return 0;
    }
}
