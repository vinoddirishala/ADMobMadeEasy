package com.vinoddirishala.adsmadeeasy;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/**
 * Created by Vinod Dirishala on 03-08-2020 16:49
 **/

public class BannerADView extends FrameLayout {

    String BANNER_ADTYPE = "banner";
    String BANNER_ADID = "ca-app-pub-3940256099942544/6300978111"; // TEST BANNER AD ID GIVEN BY GOOGLE ADMOB

    public BannerADView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        try {
            TypedArray bannerADdata = getContext().obtainStyledAttributes(attrs,R.styleable.BannerADView,0,0);
            BANNER_ADID = bannerADdata.getString(R.styleable.BannerADView_bannerAdID);
            BANNER_ADTYPE = bannerADdata.getString(R.styleable.BannerADView_bannerAdType);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
        initADView(context);
    }

    void initADView(Context mctx){
        LayoutParams bannerLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        AdView bannerADView = new AdView(mctx);
        bannerADView.setLayoutParams(bannerLayoutParams);
        bannerADView.setAdUnitId(BANNER_ADID);
        bannerADView.setAdSize(BANNER_ADTYPE.toLowerCase().equalsIgnoreCase("banner") ? AdSize.BANNER:AdSize.LARGE_BANNER);
        addView(bannerADView);
        AdRequest adRequest = new AdRequest.Builder().build();
        bannerADView.loadAd(adRequest);
    }
    
}
