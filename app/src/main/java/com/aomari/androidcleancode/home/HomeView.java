package com.aomari.androidcleancode.home;

import com.aomari.androidcleancode.models.PhotosListResponse;

/**
 * Created by aomari on 12/06/2017.
 * HomeView
 */
public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getPhotosListSuccess(PhotosListResponse photosListResponse);

}
