package com.vinoddirishala.adsmadeeasysample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vinoddirishala.adsmadeeasy.InterstitialAD;
import com.vinoddirishala.adsmadeeasy.RewardVideoAD;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button interstitial = findViewById(R.id.interstitial);
        Button reward = findViewById(R.id.reward);

        interstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InterstitialAD interstitialAD = new InterstitialAD(MainActivity.this,"ca-app-pub-3940256099942544/1033173712");
            }
        });
        reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RewardVideoAD rewardVideoAD = new RewardVideoAD(MainActivity.this,"ca-app-pub-3940256099942544/5224354917");
            }
        });

    }
}