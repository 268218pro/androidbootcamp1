package com.dsc.android.bootcamp1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RecyclerViewData implements Serializable {

    @SerializedName("image")
    @Expose // upar wala naam hi, is the key in the response coming to us...
    private String image;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("number")
    @Expose
    private String number;

//    public RecyclerViewData(String image, String name, String number) {
//        this.image = image;
//        this.name = name;
//        this.number = number;
//    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

