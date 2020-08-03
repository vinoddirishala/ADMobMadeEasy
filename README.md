# ADMobMadeEasy
This library is to help you integrating google AD Mob ads integration easy...!

Integration Steps


Step 1 :

Add ADMob Application ID to your application level manifest like below

<application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">

        <activity android:name=".MainActivity">
            <intent-filter>
                <category android:name="android.intent.category.LAUNCHER"/>
                <action android:name="android.intent.action.MAIN"/>
                <action android:name="android.intent.action.VIEW"/>
            </intent-filter>
        </activity>

        <meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="ca-app-pub-3940256099942544~3347511713"/>

    </application>

