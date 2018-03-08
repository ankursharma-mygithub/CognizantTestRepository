package com.android.testproject.canadafacts.di;

import com.android.testproject.canadafacts.network.GlideImageDownloader;
import com.android.testproject.canadafacts.network.ImageDownloaderContract;
import com.android.testproject.canadafacts.ui.MainContract;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ankursharma on 3/8/18.
 */

/**
 * Module part of Dragger2
 */
@Module
public class PresenterModule {
    MainContract.View mView;
    public PresenterModule(MainContract.View view) {
        mView = view;
    }

    @Provides
    @Singleton
    public MainContract.View provideView() {
        return mView;
    }

    @Provides
    @Singleton
    public ImageDownloaderContract provideImageDownloader() {
        return new GlideImageDownloader();
    }

    @Provides
    @Singleton
    public CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }
}
