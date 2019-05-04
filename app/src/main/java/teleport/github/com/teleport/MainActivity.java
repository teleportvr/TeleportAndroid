package teleport.github.com.teleport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private int headsetID;
    private int eventID;

    EditText headSetInput;
    EditText eventInput;

    Button connectButton; //🎵Can I get a connection🎵

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headSetInput = (EditText) findViewById(R.id.headsetIDInput);
        eventInput = (EditText) findViewById(R.id.eventIDInput);
        connectButton = (Button) findViewById(R.id.connectButton);
    }

    /**
     *
     * @param view
     * This method is called when the connectButton is clicked
     */
    public void connectToServer(View view){

        try {

            headsetID = Integer.parseInt(headSetInput.getText().toString());
            eventID = Integer.parseInt(eventInput.getText().toString());
            //showToast("headsetID: " + headsetID + "\neventID: " + eventID);

            new sendData(this).execute("URLasdf", headsetID + ", " +  eventID);
            //showToast("executing task");

        }catch(Exception e){
            if (e instanceof NumberFormatException) {
                showToast("ERROR: ID must be a number");
            }
        }
    }

    /**
     * print things on screen for debugging
     */
    public void showToast(String cheers){
        Toast.makeText(MainActivity.this, cheers, Toast.LENGTH_SHORT).show();
    }
}
