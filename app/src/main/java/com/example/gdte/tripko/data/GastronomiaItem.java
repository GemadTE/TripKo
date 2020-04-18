package com.example.gdte.tripko.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class GastronomiaItem {

    private int id;
    private String content;

    @SerializedName("gastronomiaDetail")
    public List<GastronomiaDetailItem> items;

    public GastronomiaItem(int id, String content){
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return content;
    }
}
