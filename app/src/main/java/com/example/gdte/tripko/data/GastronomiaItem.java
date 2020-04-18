package com.example.gdte.tripko.data;

import java.util.List;



public class GastronomiaItem {

    private int id;
    private String content;
    private List<GastronomiaDetailItem> items;

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

    public List<GastronomiaDetailItem> getItems() {
        return items;
    }

    public void setItems(List<GastronomiaDetailItem> items) {
        this.items = items;
    }

    @Override
    public String toString(){
        return content;
    }
}
