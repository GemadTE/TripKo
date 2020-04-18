package com.example.gdte.tripko.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegionesItem {

    private int id;

    private String content;

    @SerializedName("gastronomiaItem")
    public List<GastronomiaItem> gastronomiaItemList;

    @Override
    public String toString() {
        return content;
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
}
