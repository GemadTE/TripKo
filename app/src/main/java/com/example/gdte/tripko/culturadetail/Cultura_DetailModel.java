package com.example.gdte.tripko.culturadetail;

import android.util.Log;

public class Cultura_DetailModel implements Cultura_DetailContract.Model {

    public static String TAG = Cultura_DetailModel.class.getSimpleName();

    private String data;

    public Cultura_DetailModel(String data) {
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
