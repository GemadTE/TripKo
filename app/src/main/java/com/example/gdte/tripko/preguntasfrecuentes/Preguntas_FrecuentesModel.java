package com.example.gdte.tripko.preguntasfrecuentes;

import android.util.Log;

public class Preguntas_FrecuentesModel implements Preguntas_FrecuentesContract.Model {

    public static String TAG = Preguntas_FrecuentesModel.class.getSimpleName();

    private String data;

    public Preguntas_FrecuentesModel(String data) {
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
