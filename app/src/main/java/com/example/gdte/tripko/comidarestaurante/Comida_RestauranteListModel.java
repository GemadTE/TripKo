package com.example.gdte.tripko.comidarestaurante;

public class Comida_RestauranteListModel implements Comida_RestauranteListContract.Model {

    public static String TAG = Comida_RestauranteListModel.class.getSimpleName();

    private String data;

    public Comida_RestauranteListModel(String data) {
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
