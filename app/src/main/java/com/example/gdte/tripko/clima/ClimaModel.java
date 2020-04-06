package com.example.gdte.tripko.clima;

import android.util.Log;

public class ClimaModel implements ClimaContract.Model {

    public static String TAG = ClimaModel.class.getSimpleName();

    public ClimaModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
