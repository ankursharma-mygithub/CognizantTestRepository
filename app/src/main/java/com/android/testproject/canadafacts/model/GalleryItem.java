package com.android.testproject.canadafacts.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents each individual row item in the list displayed to the user
 * Created by ankursharma on 3/8/18.
 */

public class GalleryItem {

    //Title of the row information
    @SerializedName("title")
    private String mTitle;

    //Description
    @SerializedName("description")
    private String mDescription;

    //Image hyperlink
    @SerializedName("imageHref")
    private String mImageHref;

    public GalleryItem(String title, String description, String imageHref) {
        this.mTitle = title;
        this.mDescription = description;
        this.mImageHref = imageHref;
    }

    //Getter and setter functions

    //Get title
    public String getTitle() {
        return mTitle;
    }

    //Set title
    public void setTitle(String title) {
        mTitle = title;
    }

    //Get description
    public String getDescription() {
        return mDescription;
    }

    //Set description
    public void setDescription(String description) {
        mDescription = description;
    }

    //Get Image URL
    public String getImageUrl() {
        return mImageHref;
    }

    //Set Image URL
    public void setImageUrl(String imageUrl) {
        mImageHref = imageUrl;
    }
}
