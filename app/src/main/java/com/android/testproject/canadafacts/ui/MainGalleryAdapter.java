package com.android.testproject.canadafacts.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.testproject.canadafacts.R;

import com.android.testproject.canadafacts.ui.MainContract.Presenter;

/**
 * Adapter for the recyclerView for the main screen.The adapter doesn't store the data and works with presenter layer to
 * get and display the data.
 * Created by ankursharma on 3/8/18.
 */

public class MainGalleryAdapter extends RecyclerView.Adapter<MainGalleryAdapter.GalleryViewHolder>{
    private Presenter mMainActivityPresenter;

    public MainGalleryAdapter(Presenter presenter) {
        mMainActivityPresenter = presenter;
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.gallery_item_layout, parent, false);
        return new GalleryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position) {
        mMainActivityPresenter.onBindItemAtPosition(holder, position);
    }

    @Override
    public int getItemCount() {
        return mMainActivityPresenter.getItemsCount();
    }


    /**
     * View holdler for recyclerview
     */
    public class GalleryViewHolder extends RecyclerView.ViewHolder implements MainContract.RowItemHolder{
        private TextView mTitleTextView;
        private TextView mDetailsTextView;
        private ImageView mImageView;

        public GalleryViewHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.item_title);
            mDetailsTextView = (TextView)itemView.findViewById(R.id.item_description);
            mImageView = (ImageView)itemView.findViewById(R.id.item_image);
        }

        @Override
        public void updateTitle(String titleText) {
            mTitleTextView.setText(titleText);
        }

        @Override
        public void updateDescription(String descText) {
            mDetailsTextView.setText(descText);
        }

        @Override
        public ImageView getImageView() {
            return mImageView;
        }
    }
}
