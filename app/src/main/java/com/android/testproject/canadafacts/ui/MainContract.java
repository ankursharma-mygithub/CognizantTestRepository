package com.android.testproject.canadafacts.ui;

import android.widget.ImageView;

/**
 * Contract for View/Presenter layers.
 * Created by ankursharma on 3/8/18.
 */

public class MainContract {

    //Presenter layer contract
    interface Presenter {
        void getDataFromURL();
        void onBindItemAtPosition(RowItemHolder holder, int position);
        int getItemsCount();
        void onStop();
    }

    //View layer contract
    interface View {
        void updateTitleBar(String titleText);
        void displayListOfItems();
        void showErrorDialog(int errorId);
        void showErrorDialog(String message);
        void showWait();
        void removeWait();
    }

    //Contract for the view holder
    interface RowItemHolder {
        void updateTitle(String titleText);
        void updateDescription(String descText);
        ImageView getImageView();
    }

}
