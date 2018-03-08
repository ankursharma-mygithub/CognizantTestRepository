package com.android.testproject.canadafacts.ui;

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
    public int getItemsCount() {
        return 0;
    }

    @Override
    public void onStop() {

    }
}
