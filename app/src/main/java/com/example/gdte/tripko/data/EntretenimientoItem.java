package com.example.gdte.tripko.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EntretenimientoItem {

    public int id;
    public String title;

    @SerializedName("sitiosDeEntretenimiento")
    public List<EntretenimientoDetailItem> entretenimientoDetailItems;

    @Override
    public String toString() {
        return title;
    }
}
