package com.example.gdte.tripko.elegiridioma;

public class ElegirI_diomaModel implements Elegir_IdiomaContract.Model {

    public static String TAG = ElegirI_diomaModel.class.getSimpleName();

    public ElegirI_diomaModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
