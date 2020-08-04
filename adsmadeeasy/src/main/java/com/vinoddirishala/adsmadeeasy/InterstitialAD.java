package com.vinoddirishala.adsmadeeasy;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Vinod Dirishala on 04-08-2020 11:34
 **/

public class InterstitialAD extends AdListener {

    private Context mContext;
    // sample test interstitial ad given by google admob
    private String interstitialAdID = "ca-app-pub-3940256099942544/1033173712";
    private InterstitialAd mInterstitialAd;
    InterstitialADResponse interstitialADResponse;

    public InterstitialAD(Context context, String adID) {
        this.mContext = context;
        this.interstitialAdID = adID;
        loadInterstitialAD();
    }

    void loadInterstitialAD() {
        mInterstitialAd = new InterstitialAd(mContext);
        mInterstitialAd.setAdUnitId(interstitialAdID);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(this);
    }


    @Override
    public void onAdLoaded() {
        super.onAdLoaded();
        if (mInterstitialAd != null) {
            mInterstitialAd.show();
        }
    }

    @Override
    public void onAdClosed() {
        super.onAdClosed();
        interstitialADResponse.onIAdClosed();
    }

    @Override
    public void onAdFailedToLoad(int i) {
        super.onAdFailedToLoad(i);
        interstitialADResponse.onIAdFailedToLoad(i);
    }

}
