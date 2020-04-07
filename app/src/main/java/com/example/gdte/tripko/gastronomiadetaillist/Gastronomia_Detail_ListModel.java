package com.example.gdte.tripko.gastronomiadetaillist;

public class Gastronomia_Detail_ListModel implements Gastronomia_Detail_ListContract.Model {

    public static String TAG = Gastronomia_Detail_ListModel.class.getSimpleName();

    private String data;

    public Gastronomia_Detail_ListModel(String data) {
        this.data = data;
    }

    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }

    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}
