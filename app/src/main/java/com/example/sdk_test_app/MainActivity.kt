package com.example.sdk_test_app

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.smartcar.sdk.SmartcarAuth
import java.util.*


class MainActivity : ComponentActivity() {
    private lateinit var returnUriTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        returnUriTextView = findViewById(R.id.return_uri_text_view)
        val randomTextView = findViewById<TextView>(R.id.random_text_view)
        randomTextView.text = UUID.randomUUID().toString()

        val openButton: Button = findViewById(R.id.button_open_webview)
        openButton.setOnClickListener {
            val smartcarAuth = SmartcarAuth(
                "<client id>",
                "testapp://exchange",
                arrayOf("read_vehicle_info", "read_odometer")

            )  // Create a callback to handle the redirect response

            { smartcarResponse -> // Retrieve the authorization code
                Log.d("SmartcarAuth", "Authorization code: " + smartcarResponse.code)
                returnUriTextView.text = buildString {
                    append("Authorization code: ")
                    append(smartcarResponse.code)
                }
            }

            smartcarAuth.launchAuthFlow(applicationContext)
        }
    }
}
