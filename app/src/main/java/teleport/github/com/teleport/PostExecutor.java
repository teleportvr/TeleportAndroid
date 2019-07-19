package teleport.github.com.teleport;

import android.util.Log;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostExecutor {

    private static final String TAG = PostExecutor.class.getName();

    private OkHttpClient client = new OkHttpClient();

    public String post(String url, String headSetId, String eventId) {
        RequestBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("headsetId", headSetId)
                .addFormDataPart("camId", eventId)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body() != null ? response.body().string() : null;
        } catch(IOException e) {
            Log.e(TAG, e.getMessage(), e);
            
            return e.toString();
        }
    }
}
