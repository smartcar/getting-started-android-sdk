package com.smartcargettingstartedproject

import android.content.Intent
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
}
