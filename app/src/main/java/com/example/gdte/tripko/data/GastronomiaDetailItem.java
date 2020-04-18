package com.example.gdte.tripko.data;

public class GastronomiaDetailItem {

    private int id;

    private String comidaContent;
    private String comidaTitle;

    private int gastronomiaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComidaContent() {
        return comidaContent;
    }

    public void setComidaContent(String comidaContent) {
        this.comidaContent = comidaContent;
    }

    public String getComidaTitle() {
        return comidaTitle;
    }

    public void setComidaTitle(String comidaTitle) {
        this.comidaTitle = comidaTitle;
    }

    public int getGastronomiaId() {
        return gastronomiaId;
    }

    public void setGastronomiaId(int gastronomiaId) {
        this.gastronomiaId = gastronomiaId;
    }

    @Override
    public String toString(){ return comidaContent;}
}
