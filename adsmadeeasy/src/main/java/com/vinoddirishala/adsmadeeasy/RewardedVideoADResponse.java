package com.vinoddirishala.adsmadeeasy;

/**
 * Created by Vinod Dirishala on 04-08-2020 12:00
 **/
public interface RewardedVideoADResponse {



    void onRVAdClosed();

    void onRVAdFailedToLoad(int var1);

    void onRewarded(int amount,String rewardType);
}
