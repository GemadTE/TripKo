package com.example.gdte.tripko.idiomacoreano;

import android.util.Log;

public class Idioma_CoreanoModel implements Idioma_CoreanoContract.Model {

    public static String TAG = Idioma_CoreanoModel.class.getSimpleName();

    public Idioma_CoreanoModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
