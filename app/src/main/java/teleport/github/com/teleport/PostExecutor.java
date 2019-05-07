package teleport.github.com.teleport;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostExecutor {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    public String post(String url, String headSetID, String eventID){
        RequestBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("headSetID", ""+headSetID)
                .addFormDataPart("camID", "" + eventID)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }
        catch(Exception e){
            Log.e("TAG", e.toString());
            return e.toString();
        }
    }
}
