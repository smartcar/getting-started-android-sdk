This is the starter kit for Android SDK.

This kit contains a simple Android application that displays car information using Smartcar's Android SDK.

## Instructions
Before we get started, create an application on [Smartcar's Developer Dashboard](https://dashboard.smartcar.com) to get your API keys.

**Note:** On the dashboard, add a redirect uri on the credentials tab with the following format: `sc` + `yourClientId` + `://exchange`. For example: `sc42d24fb4-74e7-4e3b-b82a-913fa9345d1a://exchange`.

Then, we can set these constants in `strings.xml` -
```xml
<string name="smartcar_auth_scheme">sc[yourClientId]</string>
<string name="client_id">[yourClientId]</string>
```

Next, we need to setup the custom URL scheme in the `AndroidManifest.xml` -

```xml
<activity android:name="com.smartcar.sdk.SmartcarCodeReceiver">
  <intent-filter>
    <action android:name="android.intent.action.VIEW" />
    <category android:name="android.intent.category.DEFAULT" />
    <category android:name="android.intent.category.BROWSABLE" />
    <data
      android:host="@string/smartcar_auth_host"
      android:scheme="@string/smartcar_auth_scheme" />
  </intent-filter>
</activity>
```

Before setting up the client code, make sure to set up the server code. You can use any of our following back-end SDKs -
* [Node SDK](https://github.com/smartcar/getting-started-node-sdk)
* [Python SDK](https://github.com/smartcar/getting-started-python-sdk)
* [Java SDK](https://github.com/smartcar/getting-started-java-sdk)

Follow the setup instructions in the back-end README except for the `redirect_uri`. Make sure the `redirect_uri` environment variable in the back-end directory is the same as the one we have set above.

Now that the server is ready, you can set up the client (the React application).

Set the server `uri` in `strings.xml`. This should be from your back-end directory and is set to `http://10.0.2.2:8000` by default. We do not set the redirect_uri to the localhost because the Android emulator runs in a VM, therefore localhost will be the emulator's own loopback address.

```xml
<string name="app_server">[yourAppServer]</string>
```
Make sure you have cloned this repo -
```bash
$ git clone git@github.com:smartcar/getting-started-android-sdk.git
$ cd getting-started-android-sdk/app
```
To install the required dependencies -
```bash
./gradlew build
```

Run the Android simulator within Android Studio! In our current set up, we are using Smartcar's [test mode](https://smartcar.com/docs/guides/testing/), so you can log in with any username and password and you will see information of a simulated vehicle.
