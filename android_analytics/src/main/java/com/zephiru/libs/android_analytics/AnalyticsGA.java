package com.zephiru.libs.android_analytics;

/**
 * Created by Charles.Ko on 3/25/14.
 */
import com.google.analytics.tracking.android.*;

import android.app.Activity;
import android.content.Context;
public class AnalyticsGA implements AnalyticsInterface{

    private Tracker mTracker;
    private GoogleAnalytics mGA;

    private static final Logger.LogLevel LOG_LEVEL = Logger.LogLevel.INFO;

    public AnalyticsGA(Context cxt, String tracking_id, boolean dry){
        mGA = GoogleAnalytics.getInstance(cxt);
        mTracker = mGA.getTracker(tracking_id);
        mGA.setDryRun(dry);
        mGA.getLogger().setLogLevel(LOG_LEVEL);
    }


    public void logScreen(String screenName, Activity activity){
        mTracker.set(Fields.SCREEN_NAME, screenName);
        mTracker.send(MapBuilder
                .createAppView().build());
        // Nothing to do with the activity here
    }

    public void exitScreen(String screenName, Activity activity){
        // Nothing to do here
    }

    public void logEvent(String eventName){
        this.logEvent(eventName, null, null, null);

    }

    public void logEvent(String eventName, String category, String label ){
        this.logEvent(eventName, category, label, null);

    }

    public void logEvent(String eventName, String category, String label, Long value ){
        mTracker.send(MapBuilder
                .createEvent(category, eventName, label, value).build());
    }

    public void logError(String error, String message, Throwable exc){
        // Presumes not fatal just like AnalyticsKit does
        mTracker.send(MapBuilder
                .createException(error.concat(" | ").concat(message), false).build());
    }
}
