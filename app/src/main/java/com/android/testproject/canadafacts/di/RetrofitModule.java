package com.android.testproject.canadafacts.di;

import com.android.testproject.canadafacts.common.Constants;
import com.android.testproject.canadafacts.network.ApiEndPoint;
import com.android.testproject.canadafacts.network.DataFetcherContract;
import com.android.testproject.canadafacts.network.RetrofitDownloaderService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ankursharma on 3/8/18.
 */

/**
 * Module for initializng retorfit call for downloading JSON.
 */

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    Retrofit provideCall() {

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public ApiEndPoint providesNetworkService(
            Retrofit retrofit) {
        return retrofit.create(ApiEndPoint.class);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public DataFetcherContract providesService(
            ApiEndPoint networkService) {
        return new RetrofitDownloaderService(networkService);
    }

}

