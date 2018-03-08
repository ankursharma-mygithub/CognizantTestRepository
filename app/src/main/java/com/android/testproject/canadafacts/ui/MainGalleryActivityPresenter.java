package com.android.testproject.canadafacts.ui;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.android.testproject.canadafacts.R;
import com.android.testproject.canadafacts.common.AppController;
import com.android.testproject.canadafacts.common.Utils;
import com.android.testproject.canadafacts.model.GalleryItem;
import com.android.testproject.canadafacts.model.GalleryItemsList;
import com.android.testproject.canadafacts.network.DataFetcherContract;
import com.android.testproject.canadafacts.network.ImageDownloaderContract;
import com.android.testproject.canadafacts.network.RetrofitDownloaderService;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * "Presenter" layer for Main Activity - Responsible for handling all events from the activity layer.
 * Created by ankursharma on 3/8/18.
 */

public class MainGalleryActivityPresenter implements MainContract.Presenter {

    private static final String TAG = "MainGalleryPresenter";

    //Main Activity
    private MainContract.View mGalleryActivity;

    //Model data
    private GalleryItemsList mGalleryItemsList;
    private Context mContext;

    //To manage multiple RxJava subscriptions
    private CompositeSubscription mSubscriptions;

    //To download data using Retrofit and then informing presenter
    private final DataFetcherContract mService;

    //Image downloader
    private ImageDownloaderContract mImageDownloader;

    @Inject
    public MainGalleryActivityPresenter(DataFetcherContract service, MainContract.View view, ImageDownloaderContract imageDownloader) {
        mGalleryActivity = view;
        mContext = AppController.getContext();
        mSubscriptions = new CompositeSubscription();
        mService = service;
        mImageDownloader = imageDownloader;
    }

    /**
     * Gets data from the URL to populate the recyclerview
     */
    @Override
    public void getDataFromURL() {
        if(Utils.isNetworkConnected(mContext)) {
            mGalleryActivity.showWait();
            Subscription subscription = mService.getItemsList(new RetrofitDownloaderService.GetGalleryItemsListCallback() {
                @Override
                public void onSuccess(GalleryItemsList galleryItemsList) {
                    //If there is an item in the list without any information, don't display.
                    removeNullItemsFromList(galleryItemsList);
                    mGalleryItemsList = galleryItemsList;
                    mGalleryActivity.removeWait();
                    mGalleryActivity.updateTitleBar(galleryItemsList.getTitle());
                    mGalleryActivity.displayListOfItems();
                }

                @Override
                public void onError(String message) {
                    mGalleryActivity.removeWait();
                    mGalleryActivity.showErrorDialog(message);
                }

            });
            mSubscriptions.add(subscription);
        } else {
            Log.e(TAG, "Internet disconnected");
            mGalleryActivity.showErrorDialog(R.string.internet_not_connected);
        }
    }


    /**
     * Binds item to the individual view holder. Thsi ensures that the list is not
     * maintained at two places.
     * @param holder :: Respective view holder
     * @param position :: position of the view holder
     */
    @Override
    public void onBindItemAtPosition(final MainContract.RowItemHolder holder, int position) {
        GalleryItem item = mGalleryItemsList.getGalleryItems().get(position);
        holder.updateDescription(item.getDescription());
        holder.updateTitle(item.getTitle());
        String imageUrl = item.getImageUrl();
        final ImageView imageView = holder.getImageView();
        imageView.setVisibility(android.view.View.INVISIBLE);
        if(imageUrl != null && !imageUrl.isEmpty()) {
            mImageDownloader.downloadImage(mContext, imageUrl, holder.getImageView());
        }
    }

    /**
     * Get the number of items in the list.
     * @return
     */
    @Override
    public int getItemsCount() {
        return mGalleryItemsList.getGalleryItems().size();
    }

    @Override
    public void onStop() {
        //In case view is stopped unsubscribe all the observers.
        mSubscriptions.unsubscribe();
    }

    /**
     * To remove null items from the list.
     * @param items
     */
    private void removeNullItemsFromList(GalleryItemsList items) {
        //Clear out null values from the list
        for (GalleryItem item : new ArrayList<>(items.getGalleryItems())) {
            if (item.getDescription() == null && item.getImageUrl() == null && item.getTitle() == null) {
                items.getGalleryItems().remove(item);
            }
        }
    }
}
