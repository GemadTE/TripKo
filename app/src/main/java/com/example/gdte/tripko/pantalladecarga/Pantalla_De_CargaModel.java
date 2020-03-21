package com.example.gdte.tripko.pantalladecarga;

import android.util.Log;

public class Pantalla_De_CargaModel implements Pantalla_De_CargaContract.Model {

    public static String TAG = Pantalla_De_CargaModel.class.getSimpleName();

    public Pantalla_De_CargaModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
