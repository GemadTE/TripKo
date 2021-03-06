package com.example.gdte.tripko.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class GastronomiaItem {

    public int id;
    public String content;
    public int regionesId;

    @SerializedName("gastronomiaDetail")
    public List<GastronomiaDetailItem> items;


    public GastronomiaItem(int id, String content){
        this.id = id;
        this.content = content;
    }


    @Override
    public String toString(){
        return content;
    }
}
