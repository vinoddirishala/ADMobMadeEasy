package com.vinoddirishala.adsmadeeasysample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vinoddirishala.adsmadeeasy.InterstitialAD;
import com.vinoddirishala.adsmadeeasy.InterstitialADResponse;
import com.vinoddirishala.adsmadeeasy.RewardVideoAD;
import com.vinoddirishala.adsmadeeasy.RewardedVideoADResponse;

public class MainActivity extends AppCompatActivity implements InterstitialADResponse, RewardedVideoADResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button interstitial = findViewById(R.id.interstitial);
        Button reward = findViewById(R.id.reward);

        interstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new InterstitialAD(MainActivity.this,"ca-app-pub-3940256099942544/1033173712");
            }
        });
        reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RewardVideoAD(MainActivity.this,"ca-app-pub-3940256099942544/5224354917");
            }
        });

    }

    @Override
    public void onIAdClosed() {
        Toast.makeText(this, "AD Closed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onIAdFailedToLoad(int var1) {
        Toast.makeText(this, "Ad failed to load due to "+var1, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRVAdClosed() {
        Toast.makeText(this, "RV AD Closed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRVAdFailedToLoad(int var1) {
        Toast.makeText(this, "Ad failed to load due to "+var1, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewarded(int amount, String rewardType) {
        Toast.makeText(this, "rewarded \n"+rewardType+"\n"+amount, Toast.LENGTH_SHORT).show();
    }
}