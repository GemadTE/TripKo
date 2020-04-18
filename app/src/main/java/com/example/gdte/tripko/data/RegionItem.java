package com.example.gdte.tripko.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegionItem {

    public int id;

    public String content;

    @SerializedName("gastronomia")
    public List<GastronomiaItem> gastronomiaItemList;

    @Override
    public String toString() {
        return content;
    }

}
