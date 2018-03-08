package com.android.testproject.canadafacts.ui;

import android.content.DialogInterface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.testproject.canadafacts.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainGalleryActivity extends AppCompatActivity implements MainContract.View{

    //For logging purpose
    private static final String TAG = "MainGalleryActivity";

    //Use BUTTERKNIFE library to bind the views

    //RecyclerView
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    //Progress bar
    @BindView(R.id.progress)
    ProgressBar mProgressBar;

    //SwipeRefreshLayout is a part of support library and is a standard way to implement
    //common pull to refresh pattern in Android
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gallery);
        ButterKnife.bind(this);
        //Initialize the views
        initializeViews();
    }

    /**
     * Helper method to initialize the widgets
     */
    private void initializeViews() {
        //reset title bar text to empty text.
        //This will be updated from the JSON data.
        updateTitleBar("");

        //initialize swipe refresh layout
        if(mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    mSwipeRefreshLayout.setRefreshing(false);
                    //TodO:Get list of items here
                }
            });
        }

        //initialize recyclerview
        if(mRecyclerView != null) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(MainGalleryActivity.this));
        }
    }

    /**
     * Update title bar of the main view.
     * @param titleText : title to be updated
     */
    @Override
    public void updateTitleBar(String titleText) {
        if(titleText != null && !titleText.isEmpty()) {
            getSupportActionBar().setTitle(titleText);
        }
    }

    /**
     * Display list of items retrieved from the JSON file.
     */
    @Override
    public void displayListOfItems() {
        //Todo:
    }

    /**
     * Shows an error message to the user
     * @param errorId : resource id of the string to display
     */
    @Override
    public void showErrorDialog(int errorId) {
        //Todo:
    }

    /**
     * Shows an error message to the user
     * @param message : Message to display
     */
    @Override
    public void showErrorDialog(String message) {
        Log.e(TAG, message);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainGalleryActivity.this);
        //To handle use case where user tries to refresh the view and device is not connected.
        builder.setTitle(R.string.error_message)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //For now if any error comes just exit the application.
                        //Todo: This can be later optimized to find different kinds of errors and
                        //prompting the user to take action accordingly
                        finish();
                    }
                })
                .show();
    }

    /**
     * Hide the progressbar
     */
    @Override
    public void showWait() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    /**
     * SHow the progress bar
     */
    @Override
    public void removeWait() {
        mProgressBar.setVisibility(View.GONE);
    }

    /**
     * Activity lifecycle callback
     */
    @Override
    protected void onStop() {
        super.onStop();
    }
}
