package com.android.testproject.canadafacts.network;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by ankursharma on 3/9/18.
 */

/**
 * Interface that must be implemented by Image Downloader component of application
 */
public interface ImageDownloaderContract {
    void downloadImage(Context context, String url, ImageView imageView);
}
