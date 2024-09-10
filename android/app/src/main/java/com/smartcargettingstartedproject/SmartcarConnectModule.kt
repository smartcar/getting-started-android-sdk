package com.smartcargettingstartedproject

import android.content.Intent
import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.Callback
import com.smartcar.sdk.SmartcarAuth

class SmartcarConnectModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    override fun getName() = "SmartcarConnectModule"

    @ReactMethod
    fun connectToSmartcar(
        clientId: String,
        returnUri: String,
        scope: ReadableArray,
        callback: Callback
    ) {
        val scopeArray: Array<String> = Array(scope.size()) { i ->
            scope.getString(i)
        }
        val smartcarAuth = SmartcarAuth(
            clientId,
            returnUri,
            scopeArray
        )
        { smartcarResponse -> // Retrieve the authorization code
            callback.invoke(smartcarResponse.code)
        }

        smartcarAuth.launchAuthFlow(currentActivity)
    }
}
