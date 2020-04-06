package com.example.gdte.tripko.ciudadesprincipales;

import android.util.Log;

public class Ciudades_PrincipalesModel implements Ciudades_PrincipalesContract.Model {

    public static String TAG = Ciudades_PrincipalesModel.class.getSimpleName();

    public Ciudades_PrincipalesModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
