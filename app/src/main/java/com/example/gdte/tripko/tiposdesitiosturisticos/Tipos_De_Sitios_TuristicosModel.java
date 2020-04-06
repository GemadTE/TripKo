package com.example.gdte.tripko.tiposdesitiosturisticos;

import android.util.Log;

public class Tipos_De_Sitios_TuristicosModel implements Tipos_De_Sitios_TuristicosContract.Model {

    public static String TAG = Tipos_De_Sitios_TuristicosModel.class.getSimpleName();

    public Tipos_De_Sitios_TuristicosModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
