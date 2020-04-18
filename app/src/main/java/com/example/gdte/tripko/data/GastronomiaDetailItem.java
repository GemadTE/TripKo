package com.example.gdte.tripko.data;

public class GastronomiaDetailItem {

    public int id;

    public String comidaContent;
    public String comidaTitle;

    public int gastronomiaId;

    public int getId() {
        return id;
    }


    @Override
    public String toString(){ return comidaContent;}
}
