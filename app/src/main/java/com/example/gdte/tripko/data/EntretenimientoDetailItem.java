package com.example.gdte.tripko.data;

public class EntretenimientoDetailItem {
    public int id;

    public String entretenimientoContent;
    public String entretenimientoTitle;

    public int entretenimientoId;

    public int getId() {
        return id;
    }


    @Override
    public String toString(){ return entretenimientoContent;}
}
