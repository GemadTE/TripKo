package com.example.gdte.tripko.idioma;

import android.util.Log;

public class IdiomaModel implements IdiomaContract.Model {

    public static String TAG = IdiomaModel.class.getSimpleName();

    public IdiomaModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
