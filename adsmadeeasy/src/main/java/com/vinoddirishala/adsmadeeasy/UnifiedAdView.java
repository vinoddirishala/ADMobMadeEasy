package com.vinoddirishala.adsmadeeasy;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;

/**
 * Created by Vinod Dirishala on 15-07-2020 12:50
 **/

public class UnifiedAdView extends FrameLayout {

    UnifiedNativeAd nativeAd;
    String UNIFIED_ADID = "ca-app-pub-3940256099942544/2247696110\n"; // default ad id from google admob

    public UnifiedAdView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        try {
            TypedArray unifiedAdData = getContext().obtainStyledAttributes(attrs,R.styleable.UnifiedAdView,0,0);
            UNIFIED_ADID = unifiedAdData.getString(R.styleable.UnifiedAdView_unifiedAdID);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        initViews(context);
    }

    void initViews(Context mCtx){
        View unifiedNativeAdView = inflate(mCtx, R.layout.unified_adview,this);
        refreshAd(mCtx,unifiedNativeAdView);
    }

    void populateUnifiedNativeAdView(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView) {
        MediaView mediaView = adView.findViewById(R.id.media_view);
        adView.setMediaView(mediaView);
        adView.setHeadlineView(adView.findViewById(R.id.primary));
        adView.setBodyView(adView.findViewById(R.id.body));
        adView.setCallToActionView(adView.findViewById(R.id.cta));
        adView.setIconView(adView.findViewById(R.id.icon));
        adView.setPriceView(adView.findViewById(R.id.secondary));
        adView.setStarRatingView(adView.findViewById(R.id.rating_bar));
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());

        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        }
        else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        }
        else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        }
        else {
            ((ImageView) adView.getIconView()).setImageDrawable(
                    nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        }
        else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        }
        else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        adView.setNativeAd(nativeAd);

        VideoController vc = nativeAd.getVideoController();

        if (vc.hasVideoContent()) {


            vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                @Override
                public void onVideoEnd() {
                    super.onVideoEnd();
                }
            });
        }
    }

    void refreshAd(final Context mCtx,final View view) {
        AdLoader.Builder builder = new AdLoader.Builder(mCtx,UNIFIED_ADID);
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                if (nativeAd != null) {
                    nativeAd.destroy();
                }
                nativeAd = unifiedNativeAd;
                UnifiedNativeAdView adView = view.findViewById(R.id.native_ad_view);
                populateUnifiedNativeAdView(unifiedNativeAd, adView);
            }
        });

        VideoOptions videoOptions = new VideoOptions.Builder().setStartMuted(false).build();

        NativeAdOptions adOptions = new NativeAdOptions.Builder().setVideoOptions(videoOptions).build();

        builder.withNativeAdOptions(adOptions);

        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d("onAdFailedToLoad","Failed load ad");

            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());
    }

}
