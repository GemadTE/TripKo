package com.example.gdte.tripko.data;

import java.util.List;

public class Sitios_TuristicosItem {

    public int id;

    public String title;

    public List<SitiosTuristicosDetailItem> sitiosTuristicosDetailItems;

    @Override
    public String toString() {
        return title;
    }
}
