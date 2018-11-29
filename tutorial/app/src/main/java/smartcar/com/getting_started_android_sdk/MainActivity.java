package smartcar.com.getting_started_android_sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.smartcar.sdk.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.*;

public class MainActivity extends AppCompatActivity {

    private Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appContext = getApplicationContext();

        // TODO: Step 5: Initialize the Smartcar object

        // TODO: Step 7: Receive the authorization code

        // TODO: Step 8: Obtain an access token

        // TODO: STEP 9: Get vehicle information

        Button connectButton = (Button) findViewById(R.id.connect_button);

        // TODO: Step 6: Launch the authorization flow
    }
}
