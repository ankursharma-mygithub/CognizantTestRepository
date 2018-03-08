package com.android.testproject.canadafacts.ui;

/**
 * Contract for View/Presenter layers.
 * Created by ankursharma on 3/8/18.
 */

public class MainContract {

    //Presenter layer contract
    //Presenter layer contract
    interface Presenter {
        void getDataFromURL();
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

}
