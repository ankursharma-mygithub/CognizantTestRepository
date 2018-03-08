package com.android.testproject.canadafacts.network;

import com.android.testproject.canadafacts.model.GalleryItemsList;

import rx.Subscription;

/**
 * Created by ankursharma on 3/9/18.
 */

/**
 * This must be implemented by the component that downloads the JSON file.
 */
public interface DataFetcherContract {
    Subscription getItemsList(final GetGalleryItemsListCallback callback);
    //Callback(or subscriber, or observer) interface for JSON downloader
    interface GetGalleryItemsListCallback{
        void onSuccess(GalleryItemsList galleryItemsList);
        void onError(String message);
    }
}
