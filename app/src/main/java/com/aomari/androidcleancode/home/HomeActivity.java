package com.aomari.androidcleancode.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aomari.androidcleancode.BaseApp;
import com.aomari.androidcleancode.R;
import com.aomari.androidcleancode.models.PhotosListData;
import com.aomari.androidcleancode.models.PhotosListResponse;
import com.aomari.androidcleancode.networking.Service;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseApp implements HomeView {

    @BindView(R.id.recyclerView_list)
    RecyclerView list;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    public Service service;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);

        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        list.setLayoutManager(new LinearLayoutManager(this));

        HomePresenter presenter = new HomePresenter(service, this);
        presenter.getPhotosList();
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    @Override
    public void getPhotosListSuccess(PhotosListResponse photosListResponse) {
        HomeAdapter adapter = new HomeAdapter(getApplicationContext(), photosListResponse.getData(),
                new HomeAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(PhotosListData Item) {
                        Toast.makeText(getApplicationContext(), Item.getRover().getName(),
                                Toast.LENGTH_LONG).show();
                    }
                });
        list.setAdapter(adapter);
    }
}
