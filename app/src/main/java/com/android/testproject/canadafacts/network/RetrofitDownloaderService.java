package com.android.testproject.canadafacts.network;

/**
 * Created by ankursharma on 3/9/18.
 */

import com.android.testproject.canadafacts.model.GalleryItemsList;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Uses RxJava and Retrofit library to dfownload and parse JSON file.
 */
public class RetrofitDownloaderService implements DataFetcherContract{
    private final ApiEndPoint mApiEndPoint;

    public RetrofitDownloaderService(ApiEndPoint apiEndPoint) {
        mApiEndPoint = apiEndPoint;
    }

    public Subscription getItemsList(final GetGalleryItemsListCallback callback) {
        //Use RxJava implementations to download JSON file.
        return mApiEndPoint.getItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends GalleryItemsList>>() {
                    @Override
                    public Observable<? extends GalleryItemsList> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<GalleryItemsList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getMessage());

                    }

                    @Override
                    public void onNext(GalleryItemsList galleryItemsList) {
                        //Pass the entire list to the callback implementor.
                        callback.onSuccess(galleryItemsList);
                    }
                });
    }

}
