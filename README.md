# Android-Analytics

It's a simple wrapper around various analytics tools for Android.
Currently only supports Google Analytics and Flurry with limited functionality.


## How to Use

You can either build this to .aar or just copy the classes in the package  and lib/*.jar to your project. I like the latter because you can edit the source files that way. Some settings are constants, and you want to be able to edit them freely.

Initialize by providing the GA tracking id and/or flurry app key at application launch.

```java

public class MyApp extends Application {

    private AndroidAnalytics mAndroidAnalytics;

    private static final String GA_ID = "US-XXXX-Y";
    private static final String FLURRY_APP_KEY = "abracatabra";

...

    @Override
    public void onCreate() {
        super.onCreate();
        // GA_ID and FLURRY_APP_KEY can be null. It won't use them if they are.
        mAndroidAnalytics = new AndroidAnalytics(this, GA_ID, FLURRY_APP_KEY);
    }

    public AndroidAnalytics getAnalytics(){ return mAndroidAnalytics;}

...

}


```

Do this for each of the activities you have in your application.

```java

public class HomeActivity extends Activity {

    private static final String SCREEN_LABEL = "Home";

    @Override
    public void onStart() {
        super.onStart();
        MyApp.getAnalytics().logScreen(SCREEN_LABEL, this);
    }

    @Override
    public void onStop() {
        super.onStop();
        MyApp.getAnalytics().exitScreen(SCREEN_LABEL, this);
    }
}

```

Other logging methods:
```java

public void logEvent(String eventName);

public void logEvent(String eventName, String category, String label );

public void logEvent(String eventName, String category, String label, Long value );

public void logError(String error, String message, Throwable exc);

```