package com.example.gdte.tripko.contactosdeinteres;

import android.util.Log;

public class Contactos_De_InteresModel implements Contactos_De_InteresContract.Model {

    public static String TAG = Contactos_De_InteresModel.class.getSimpleName();

    private String data;

    public Contactos_De_InteresModel(String data) {
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
