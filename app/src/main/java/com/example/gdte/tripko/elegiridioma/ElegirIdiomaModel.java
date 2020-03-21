package com.example.gdte.tripko.elegiridioma;

import android.util.Log;

public class ElegirIdiomaModel implements ElegirIdiomaContract.Model {

    public static String TAG = ElegirIdiomaModel.class.getSimpleName();

    public ElegirIdiomaModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
