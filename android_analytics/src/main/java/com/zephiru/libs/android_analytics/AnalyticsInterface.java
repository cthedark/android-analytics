package com.zephiru.libs.android_analytics;

/**
 * Created by Charles.Ko on 3/25/14.
 */
import android.app.Activity;

public interface AnalyticsInterface {

    public void logScreen(String screenName, Activity activity);

    public void enterScreen(String screenName, Activity activity);

    public void exitScreen(String screenName, Activity activity);

    public void logEvent(String eventName);

    public void logEvent(String eventName, String category, String label );

    public void logEvent(String eventName, String category, String label, Long value );

    public void logError(String error, String message, Throwable exc);

}
