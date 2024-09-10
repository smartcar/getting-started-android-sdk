package com.smartcargettingstartedproject

import android.content.Intent
import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Callback
import com.smartcar.sdk.SmartcarAuth

class SmartcarConnectModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    override fun getName() = "SmartcarConnectModule"

    @ReactMethod
    fun connectToSmartcar() {
        val smartcarAuth = SmartcarAuth(
            "<client id>",
            "testapp://exchange",
            arrayOf("read_vehicle_info", "read_odometer")
        )
        { smartcarResponse -> // Retrieve the authorization code
            Log.d("SmartcarAuth", "Authorization code: " + smartcarResponse.code)
        }

        smartcarAuth.launchAuthFlow(currentActivity)
    }
}
