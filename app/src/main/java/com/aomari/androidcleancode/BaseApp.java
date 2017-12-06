package com.aomari.androidcleancode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aomari.androidcleancode.deps.DaggerDeps;
import com.aomari.androidcleancode.deps.Deps;
import com.aomari.androidcleancode.networking.NetworkModule;

import java.io.File;

/**
 * Created by aomari on 12/06/2017.
 * BaseApp
 */
public class BaseApp  extends AppCompatActivity{
    Deps deps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();

    }

    public Deps getDeps() {
        return deps;
    }
}
