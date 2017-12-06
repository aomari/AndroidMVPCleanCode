package com.aomari.androidcleancode.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

/**
 * Created by aomari on 12/6/2017.
 * PhotosListResponse
 */
@Generated("org.jsonschema2pojo")
public class PhotosListResponse {
    @SerializedName("photos")
    @Expose
    private List<PhotosListData> data = new ArrayList<PhotosListData>();

    public List<PhotosListData> getData() {
        return data;
    }

    public void setData(List<PhotosListData> data) {
        this.data = data;
    }
}
