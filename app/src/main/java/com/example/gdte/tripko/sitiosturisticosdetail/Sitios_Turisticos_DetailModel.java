package com.example.gdte.tripko.sitiosturisticosdetail;

import android.util.Log;

public class Sitios_Turisticos_DetailModel implements Sitios_Turisticos_DetailContract.Model {

    public static String TAG = Sitios_Turisticos_DetailModel.class.getSimpleName();

    private String data;

    public Sitios_Turisticos_DetailModel(String data) {
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
