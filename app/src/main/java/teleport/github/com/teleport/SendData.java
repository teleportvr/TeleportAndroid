package teleport.github.com.teleport;

import android.os.AsyncTask;


public class SendData extends AsyncTask<String, String, String> {
    private MainActivity mainActivity;
    private PostExecutor poster;

    public SendData(MainActivity main) {
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
        String headsetId = params[1];
        String camId = params[2];

        // this is passed into the parameter result in onPostExecute
        return poster.post(urlString, headsetId, camId);
    }

    @Override
    protected void onPostExecute(String result) {
        // if this task finishes, the response from the server will show up on the screen
        mainActivity.showToast(result);
    }
}
