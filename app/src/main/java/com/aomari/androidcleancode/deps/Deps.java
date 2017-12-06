package com.aomari.androidcleancode.deps;


import com.aomari.androidcleancode.home.HomeActivity;
import com.aomari.androidcleancode.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by aomari on 12/06/2017.
 * Deps
 */
@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(HomeActivity homeActivity);
}
