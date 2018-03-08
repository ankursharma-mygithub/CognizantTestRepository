package com.android.testproject.canadafacts.network;

import com.android.testproject.canadafacts.common.Constants;
import com.android.testproject.canadafacts.model.GalleryItemsList;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ankursharma on 3/9/18.
 */
/**
 * Used by retrofit library to download JSON file
 */
public interface ApiEndPoint {
    @GET(Constants.API_END_POINT)
    Observable<GalleryItemsList> getItems();
}
