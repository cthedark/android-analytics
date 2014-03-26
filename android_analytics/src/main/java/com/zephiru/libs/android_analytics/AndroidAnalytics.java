package com.zephiru.libs.android_analytics;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charles.Ko on 3/25/14.
 */
public class AndroidAnalytics implements AnalyticsInterface{

    List<AnalyticsInterface> mAnalyticsList;

    public AndroidAnalytics(Context cxt, String ga_tracking_id, String flurry_key){
        mAnalyticsList = new ArrayList<AnalyticsInterface>();

        if(ga_tracking_id != null){
            mAnalyticsList.add(new AnalyticsGA(cxt, ga_tracking_id, true));
        }

        if(flurry_key != null){
            mAnalyticsList.add(new AnalyticsFlurry(flurry_key));
        }
    }

    public void logScreen(String screenName, Activity activity){
        for (AnalyticsInterface analyticsInterface : mAnalyticsList) {
            analyticsInterface.logScreen(screenName, activity);
        }
    }

    public void exitScreen(String screenName, Activity activity){
        for (AnalyticsInterface analyticsInterface : mAnalyticsList) {
            analyticsInterface.exitScreen(screenName, activity);
        }
    }

    public void logEvent(String eventName){
        for (AnalyticsInterface analyticsInterface : mAnalyticsList) {
            analyticsInterface.logEvent(eventName);
        }
    }

    public void logEvent(String eventName, String category, String label ){
        for (AnalyticsInterface analyticsInterface : mAnalyticsList) {
            analyticsInterface.logEvent(eventName, category, label);
        }
    }

    public void logEvent(String eventName, String category, String label, Long value ){
        for (AnalyticsInterface analyticsInterface : mAnalyticsList) {
            analyticsInterface.logEvent(eventName, category, label, value);
        }
    }

    public void logError(String error, String message, Throwable exc){
        for (AnalyticsInterface analyticsInterface : mAnalyticsList) {
            analyticsInterface.logError(error, message, exc);
        }
    }
}
