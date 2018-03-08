package com.android.testproject.canadafacts.ui;

import android.widget.ImageView;

import com.android.testproject.canadafacts.model.GalleryItem;

/**
 * "Presenter" layer for Main Activity - Responsible for handling all events from the activity layer.
 * Created by ankursharma on 3/8/18.
 */

public class MainGalleryActivityPresenter implements MainContract.Presenter {

    //For logging purposes.
    private static final String TAG = "MainGalleryPresenter";

    //Implementations for MainContractor.Presenter
    @Override
    public void getDataFromURL() {

    }

    @Override
    public void onBindItemAtPosition(MainContract.RowItemHolder holder, int position) {
        //Bind items to the holder once you get the data.
    }

    @Override
    public int getItemsCount() {
        return 0;
    }

    @Override
    public void onStop() {

    }
}
