package com.example.gdte.tripko.idiomaalfabeto;

import android.util.Log;

public class Idioma_AlfabetoModel implements Idioma_AlfabetoContract.Model {

    public static String TAG = Idioma_AlfabetoModel.class.getSimpleName();

    public Idioma_AlfabetoModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
