package com.smartcargettingstartedproject

import android.content.Intent
import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Callback
import com.smartcar.sdk.SmartcarAuth

class SmartcarConnectModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    private val REACT_CLASS = "SmartcarConnect"

    override fun getName(): String {
        return REACT_CLASS
    }

    @ReactMethod
    fun connectToSmartcar() {
        val smartcarAuth = SmartcarAuth(
            "<client id>",
            "testapp://exchange",
            arrayOf("read_vehicle_info", "read_odometer")
        )
        { smartcarResponse -> // Retrieve the authorization code
            Log.d("SmartcarAuth", "Authorization code: " + smartcarResponse.code)
            return smartcarResponse.code.toString();
        }

        smartcarAuth.launchAuthFlow(reactContext)
    }
}
