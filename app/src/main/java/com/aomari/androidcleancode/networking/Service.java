package com.aomari.androidcleancode.networking;


import com.aomari.androidcleancode.models.PhotosListResponse;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by aomari on 12/06/2017.
 * Service
 */
public class Service {
    private final NetworkService networkService;

    Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getPhotosList(final GetPhotosListCallback callback) {

        return networkService.getNasaPhotosList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends PhotosListResponse>>() {
                    @Override
                    public Observable<? extends PhotosListResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<PhotosListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(PhotosListResponse photosListResponse) {
                        callback.onSuccess(photosListResponse);

                    }
                });
    }

    public interface GetPhotosListCallback {
        void onSuccess(PhotosListResponse photosListResponse);

        void onError(NetworkError networkError);
    }
}
