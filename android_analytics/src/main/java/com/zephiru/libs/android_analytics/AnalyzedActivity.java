package com.zephiru.libs.android_analytics;

/**
 * Created by Charles.Ko on 3/26/14.
 */

import android.app.Activity;

// This is a convenience class that takes care of screen logging
public class AnalyzedActivity extends Activity{

    private String mScreenName = "Base Screen";
    private AndroidAnalytics mAndroidAnalytics;
    private boolean mAnalyticsReady = false;


    // This method has to be called in onLaunch! Or it won't do shit.
    public void setAnalyticsSettings(String screen_name, AndroidAnalytics aa){
        mScreenName = screen_name;
        mAndroidAnalytics = aa;
        mAnalyticsReady = true;
    }

    @Override
    public void onStart(){
        super.onStart();
        if (mAnalyticsReady){
            mAndroidAnalytics.logScreen(mScreenName, this);
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        if (mAnalyticsReady){
            mAndroidAnalytics.exitScreen(mScreenName, this);
        }
    }
}
