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
        String urlString = params[0]; // URL to call
        String headsetID = params[1]; //data to post
        String eventID = params[2];

        String response;
        response = poster.post(urlString, headsetID, eventID);

        //this is passed into the parameter result in onPostExecute
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        //if this task finishes, the inputted URL will show up on the screen
        mainActivity.showToast(result);
    }
}
