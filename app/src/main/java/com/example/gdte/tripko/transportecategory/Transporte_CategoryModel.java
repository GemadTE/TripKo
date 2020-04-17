package com.example.gdte.tripko.transportecategory;

import android.util.Log;

public class Transporte_CategoryModel implements Transporte_CategoryContract.Model {

    public static String TAG = Transporte_CategoryModel.class.getSimpleName();

    private String data;

    public Transporte_CategoryModel(String data) {
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
