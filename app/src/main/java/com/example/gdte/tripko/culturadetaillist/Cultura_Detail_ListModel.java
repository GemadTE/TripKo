package com.example.gdte.tripko.culturadetaillist;

import android.util.Log;

public class Cultura_Detail_ListModel implements Cultura_Detail_ListContract.Model {

    public static String TAG = Cultura_Detail_ListModel.class.getSimpleName();

    private String data;

    public Cultura_Detail_ListModel(String data) {
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
