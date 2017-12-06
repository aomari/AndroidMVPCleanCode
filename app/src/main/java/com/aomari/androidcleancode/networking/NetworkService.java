package com.aomari.androidcleancode.networking;


import com.aomari.androidcleancode.BuildConfig;
import com.aomari.androidcleancode.models.PhotosListResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by aomari on 12/06/17.
 * NetworkService
 */
public interface NetworkService {
    @GET("api/v1/rovers/curiosity/photos?sol=1000&page=2&api_key=" + BuildConfig.NASA_API_KEY)
    Observable<PhotosListResponse> getNasaPhotosList();
}
