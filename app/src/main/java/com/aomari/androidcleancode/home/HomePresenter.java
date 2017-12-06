package com.aomari.androidcleancode.home;

import com.aomari.androidcleancode.models.PhotosListResponse;
import com.aomari.androidcleancode.networking.NetworkError;
import com.aomari.androidcleancode.networking.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by aomari on 12/06/2017.
 * HomePresenter
 */
public class HomePresenter {
    private final Service service;
    private final HomeView view;
    private CompositeSubscription subscriptions;

    public HomePresenter(Service service, HomeView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getPhotosList() {
        view.showWait();

        Subscription subscription = service.getPhotosList(new Service.GetPhotosListCallback() {
            @Override
            public void onSuccess(PhotosListResponse photosListResponse) {
                view.removeWait();
                view.getPhotosListSuccess(photosListResponse);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
    }
    public void onStop() {
        subscriptions.unsubscribe();
    }
}
