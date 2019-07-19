package teleport.github.com.teleport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText headSetInput;
    private EditText camInput;

    private Button connectButton; //🎵Can I get a connection🎵

    private static String URL = "http://192.168.43.84:5001/link";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headSetInput = findViewById(R.id.headsetIDInput);
        camInput = findViewById(R.id.cameraIDInput);
        connectButton = findViewById(R.id.connectButton);
    }

    /**
     *
     * @param view
     * This method is called when the connectButton is clicked
     */
    public void connectToServer(View view) {

        try {
            String headsetId = headSetInput.getText().toString();
            String camId = camInput.getText().toString();
            Integer.parseInt(headsetId);
            Integer.parseInt(camId);

            new SendData(this).execute(URL, headsetId, camId);
        } catch(NumberFormatException e) {
            showToast("ERROR: ID must be a number");
        }
    }

    /**
     * print things on screen for debugging
     */
    public void showToast(String cheers) {
        Toast.makeText(MainActivity.this, cheers, Toast.LENGTH_SHORT).show();
    }
}
