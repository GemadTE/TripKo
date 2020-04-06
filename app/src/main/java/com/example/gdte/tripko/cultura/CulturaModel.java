package com.example.gdte.tripko.cultura;

import android.util.Log;

public class CulturaModel implements CulturaContract.Model {

    public static String TAG = CulturaModel.class.getSimpleName();

    public CulturaModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
