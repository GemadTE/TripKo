package com.example.gdte.tripko.conversormoneda;

import android.util.Log;

public class Conversor_MonedaModel implements Conversor_MonedaContract.Model {

    public static String TAG = Conversor_MonedaModel.class.getSimpleName();

    private String data;

    public Conversor_MonedaModel(String data) {
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
