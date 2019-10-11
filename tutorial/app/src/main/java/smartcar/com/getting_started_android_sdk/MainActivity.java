package smartcar.com.getting_started_android_sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;

import com.smartcar.sdk.SmartcarAuth;
import com.smartcar.sdk.SmartcarCallback;
import com.smartcar.sdk.SmartcarResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Context appContext;

    // TODO: Authorization Step 1a. Initialize the Smartcar object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appContext = getApplicationContext();

        // TODO: Authorization Step 1b: Initialize the Smartcar object

        // TODO: Authorization Step 3b: Receive the authorization code

        // TODO: Request Step 1: Obtain an access token

        // TODO: Request Step 2: Get vehicle information

        Button connectButton = findViewById(R.id.connect_button);

        // TODO: Authorization Step 2: Launch Connect
    }
}
