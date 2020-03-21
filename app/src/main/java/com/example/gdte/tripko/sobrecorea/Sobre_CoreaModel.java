package com.example.gdte.tripko.sobrecorea;

import android.util.Log;

public class Sobre_CoreaModel implements Sobre_CoreaContract.Model {

    public static String TAG = Sobre_CoreaModel.class.getSimpleName();

    public Sobre_CoreaModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
