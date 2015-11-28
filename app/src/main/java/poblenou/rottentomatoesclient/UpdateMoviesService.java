package poblenou.rottentomatoesclient;

import android.content.Context;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.TaskParams;

public class UpdateMoviesService extends GcmTaskService {
    public static void runNow(Context context) {
        OneoffTask tasca = new OneoffTask.Builder()
                .setExecutionWindow(0, 1)
                .setPersisted(true)
                .setRequiredNetwork(OneoffTask.NETWORK_STATE_CONNECTED)
                .setRequiresCharging(false)
                .setService(UpdateMoviesService.class)
                .setTag("update_movies_now")
                .build();
        GcmNetworkManager.getInstance(context).schedule(tasca);

    }

    @Override
    public int onRunTask(TaskParams taskParams) {
        String pais = "es";

        RottenTomatoesAPIClientRetrofit apiClient = new RottenTomatoesAPIClientRetrofit(this);
        apiClient.getPelicules(pais);

        return 0;
    }
}
