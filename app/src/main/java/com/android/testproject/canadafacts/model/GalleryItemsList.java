package com.android.testproject.canadafacts.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This class will be serialized from the JSON file.
 * Created by ankursharma on 3/8/18.
 */

public class GalleryItemsList {
    @SerializedName("title")
    private String title;

    @SerializedName("rows")
    private List<GalleryItem> items = null;

    public GalleryItemsList(String title, List<GalleryItem> items) {
        this.title = title;
        this.items = items;
    }

    //Get complete list fo items to be dsplayed
    public List<GalleryItem> getGalleryItems() {
        return items;
    }

    //Get title that must be shown in the title bar
    public String getTitle() {
        return title;
    }

    //Set gallery items.
    public void setGalleryItems(List<GalleryItem> items) {
        this.items = items;
    }
}
