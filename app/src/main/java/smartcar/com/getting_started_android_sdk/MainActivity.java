package smartcar.com.getting_started_android_sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    private static String CLIENT_ID;
    private static String REDIRECT_URI;
    private static String SCOPE;
    private Context appContext;
    private SmartcarAuth smartcarAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appContext = getApplicationContext();
        CLIENT_ID = getString(R.string.client_id);
        REDIRECT_URI = getString(R.string.redirect_uri);
        SCOPE = "read_vehicle_info";

        smartcarAuth = new SmartcarAuth(CLIENT_ID, REDIRECT_URI, SCOPE, true, new SmartcarCallback() {
            @Override
            public void handleResponse(final SmartcarResponse smartcarResponse) {

                final OkHttpClient client = new OkHttpClient();

                // Request can not run on the Main Thread
                // Main Thread is used for UI and therefore can not be blocked
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        // send request to exchange the auth code for the access token
                        Request exchangeRequest = new Request.Builder()
                            // Android emulator runs in a VM, therefore localhost will be the
                            // emulator's own loopback address
                            .url("http://10.0.2.2:8000/callback?code=" + smartcarResponse.getCode())
                            .build();

                        try {
                            client.newCall(exchangeRequest).execute();
                        } catch (IOException e) {}

                        // send request to retrieve the vehicle info
                        Request infoRequest = new Request.Builder()
                            .url("http://10.0.2.2:8000/vehicle")
                            .build();

                        try {
                            Response response = client.newCall(infoRequest).execute();

                            String jsonBody = response.body().string();
                            JSONObject JObject = new JSONObject(jsonBody);

                            String make = JObject.getString("make");
                            String model = JObject.getString("model");
                            String year = JObject.getString("year");

                            Intent intent = new Intent(appContext, DisplayInfoActivity.class);
                            intent.putExtra("INFO", make + " " + model + " " + year);
                            startActivity(intent);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


            }
        });

        Button connectButton = (Button) findViewById(R.id.connect_button);

        smartcarAuth.addClickHandler(appContext, connectButton);
    }
}
