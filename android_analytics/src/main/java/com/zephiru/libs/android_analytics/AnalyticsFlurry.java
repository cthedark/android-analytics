package com.zephiru.libs.android_analytics;

/**
 * Created by Charles.Ko on 3/25/14.
 */
import android.app.Activity;

import com.flurry.android.*;

import java.util.HashMap;

public class AnalyticsFlurry implements AnalyticsInterface {

    private String mFlurryKey;

    public AnalyticsFlurry(String flurry_key, boolean log_enabled){
        mFlurryKey = flurry_key;
        FlurryAgent.setLogEnabled(log_enabled);
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
        FlurryAgent.logEvent(eventName);
    }

    public void logEvent(String eventName, final String category, final String label ){
        FlurryAgent.logEvent(eventName, new HashMap<String,String>(){{
            put("Category", category);
            put("Label", label);
        }});
    }

    public void logEvent(String eventName, final String category, final String label,
                         final Long value ){
        FlurryAgent.logEvent(eventName, new HashMap<String,String>(){{
            put("Category", category);
            put("Label", label);
            put("Value", value.toString());
        }});
    }

    public void logError(String error, String message, Throwable exc){
        FlurryAgent.onError(error, message, exc);
    }
}
