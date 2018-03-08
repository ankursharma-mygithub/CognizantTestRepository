package com.android.testproject.canadafacts.common;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

/**
 * The extended application class
 * Created by ankursharma on 3/8/18.
 */

public class AppController extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
        //Add LeakCanary lib for memory leak detection.
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    public static Context getContext() {
        return mContext;
    }

}
