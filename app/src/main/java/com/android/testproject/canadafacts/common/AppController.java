package com.android.testproject.canadafacts.common;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by ankursharma on 3/8/18.
 */

/**
 * * The extended application class
 */
public class AppController extends Application {
    //Application context
    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this.getApplicationContext();
        //Add LeakCanary lib for memory leak detection.
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    public static Context getContext() {
        return mAppContext;
    }

}
