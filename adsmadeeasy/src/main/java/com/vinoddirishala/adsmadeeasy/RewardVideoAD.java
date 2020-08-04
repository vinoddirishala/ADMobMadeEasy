package com.vinoddirishala.adsmadeeasy;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/**
 * Created by Vinod Dirishala on 04-08-2020 11:52
 **/

public  class RewardVideoAD {

    private Context mContext;
    private String rewardedVideoAdID = "ca-app-pub-3940256099942544/5224354917"; // sample test interstitial ad given by google admob
    private RewardedVideoAd rewardedVideoAd;
    private RewardedVideoADResponse rewardedVideoADResponse;

    public RewardVideoAD(Context context,String rVideoAdID) {
        this.mContext = context;
        this.rewardedVideoAdID = rVideoAdID;
        rewardedVideoADResponse = (RewardedVideoADResponse)mContext;
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(mContext);
        rewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                if (rewardedVideoAd != null){
                    rewardedVideoAd.show();
                }
            }

            @Override
            public void onRewardedVideoAdOpened() {

            }

            @Override
            public void onRewardedVideoStarted() {

            }

            @Override
            public void onRewardedVideoAdClosed() {
                rewardedVideoADResponse.onRVAdClosed();
            }

            @Override
            public void onRewarded(RewardItem rewardItem) {
                rewardedVideoADResponse.onRewarded(rewardItem.getAmount(),rewardItem.getType());
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {

            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {
                rewardedVideoADResponse.onRVAdFailedToLoad(i);
            }

            @Override
            public void onRewardedVideoCompleted() {

            }
        });
        rewardedVideoAd.loadAd(rewardedVideoAdID,new AdRequest.Builder().build());
    }

}
