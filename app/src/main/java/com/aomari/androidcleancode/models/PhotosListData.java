package com.aomari.androidcleancode.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by aomari on 12/6/2017.
 * PhotosListData
 */
@Generated("org.jsonschema2pojo")
public class PhotosListData {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("img_src")
    @Expose
    private String imageSource;

    @SerializedName("earth_date")
    @Expose
    private String earthDate;

    @SerializedName("rover")
    @Expose
    private Rover rover;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }
}
