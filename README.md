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

        # <meta-data
        #   android:name="com.google.android.gms.ads.APPLICATION_ID"
        #    android:value="ca-app-pub-3940256099942544~3347511713"/>

    </application>
    
    
Step 2 :

 Add maven to your project level gradle # (project/gradle)

    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }

    }
    

Step 3 : 

Add the following implementation dependency to your application level gradle # (app/gradle)
  
      implementation 'com.github.vinoddirishala:ADMobMadeEasy:1.0.1'
     
     
Step 4 :

  Add the extended Ad Class to your XML file like below
 
      <com.vinoddirishala.adsmadeeasy.BannerADView
        android:layout_alignParentBottom="true"
        android:layout_width="match_parent"
        app:bannerAdID="ca-app-pub-3940256099942544/6300978111"
        app:bannerAdType="banner"
        android:layout_height="wrap_content"/>
  

 add your AD ID to attribute # bannerAdID and set # bannerAdType as banner or largeBanner as per your need.
 
 That's it for now.
 
 Will add other ads implementation code in near future.....
 
 
 Thank you
