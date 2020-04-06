package com.example.gdte.tripko.entretenimiento;

import android.util.Log;

public class EntretenimientoModel implements EntretenimientoContract.Model {

    public static String TAG = EntretenimientoModel.class.getSimpleName();

    public EntretenimientoModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
