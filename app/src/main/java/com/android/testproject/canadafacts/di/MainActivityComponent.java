package com.android.testproject.canadafacts.di;

/**
 * Created by ankursharma on 3/8/18.
 */

import com.android.testproject.canadafacts.ui.MainGalleryActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Component part of Dagger2 for main Activity
 */
@Singleton
@Component(modules = {RetrofitModule.class, PresenterModule.class})
public interface MainActivityComponent {
    void inject(MainGalleryActivity mainGalleryActivity);
}

