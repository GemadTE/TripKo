package com.example.gdte.tripko.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EntretenimientoItem {
    public int id;
    public String content;

    @SerializedName("entretenimiento")
    public List<EntretenimientoDetailItem> entretenimientoDetailItems;

    public EntretenimientoItem(int id, String content){
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
