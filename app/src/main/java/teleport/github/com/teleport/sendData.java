package teleport.github.com.teleport;

import android.content.Context;
import android.os.AsyncTask;


public class sendData extends AsyncTask<String, String, String> {
    MainActivity mainActivity;
    PostExecutor poster;

    public sendData(MainActivity main){
        mainActivity = main;
        poster = new PostExecutor();
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String urlString = params[0];
        String headsetID = params[1];
        String camID = params[2];

        String response = poster.post(urlString, headsetID, camID);

        //this is passed into the parameter result in onPostExecute
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        //if this task finishes, the response from the server will show up on the screen
        mainActivity.showToast(result);
    }
}
