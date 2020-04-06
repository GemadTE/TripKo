package com.example.gdte.tripko.sitiosturisticos;

import android.util.Log;

public class Sitios_TuristicosModel implements Sitios_TuristicosContract.Model {

    public static String TAG = Sitios_TuristicosModel.class.getSimpleName();

    public Sitios_TuristicosModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
