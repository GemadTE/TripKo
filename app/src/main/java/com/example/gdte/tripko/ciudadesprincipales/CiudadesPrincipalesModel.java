package com.example.gdte.tripko.ciudadesprincipales;

import android.util.Log;

public class CiudadesPrincipalesModel implements CiudadesPrincipalesContract.Model {

    public static String TAG = CiudadesPrincipalesModel.class.getSimpleName();

    public CiudadesPrincipalesModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
