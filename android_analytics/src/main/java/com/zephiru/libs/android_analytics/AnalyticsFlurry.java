package com.zephiru.libs.android_analytics;

/**
 * Created by Charles.Ko on 3/25/14.
 */
import android.app.Activity;

import com.flurry.android.*;
public class AnalyticsFlurry implements AnalyticsInterface {

    private String mFlurryKey;

    public AnalyticsFlurry(String flurry_key){
        mFlurryKey = flurry_key;
    }

    public void logScreen(String screenName, Activity activity){
        // For Android, session is per activity, not per application like iOS or WP8...
        FlurryAgent.onStartSession(activity, mFlurryKey);
        FlurryAgent.logEvent("Screen - ".concat(screenName));
    }

    public void exitScreen(String screenName, Activity activity) {
        FlurryAgent.onEndSession(activity);
    }


    public void logEvent(String eventName){
        this.logEvent(eventName, null, null, null);

    }
    public void logEvent(String eventName, String category, String label ){

    }

    public void logEvent(String eventName, String category, String label, Long value ){
    }
    public void logError(String error, String message, Throwable exc){
        FlurryAgent.onError(error, message, exc);
    }
}
