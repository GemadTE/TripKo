package com.example.gdte.tripko.gastronomiaregiones;

public class Gastronomia_RegionesModel implements Gastronomia_RegionesContract.Model {

    public static String TAG = Gastronomia_RegionesModel.class.getSimpleName();

    private String data;

    public Gastronomia_RegionesModel(String data) {
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
