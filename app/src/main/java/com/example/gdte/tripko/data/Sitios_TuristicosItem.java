package com.example.gdte.tripko.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sitios_TuristicosItem {

    public int id;

    public String title;

    @SerializedName("tiposDeSitios")
    public List<Sitios_TuristicosDetailItem> sitiosTuristicosDetailItems;

    @Override
    public String toString() {
        return title;
    }
}
