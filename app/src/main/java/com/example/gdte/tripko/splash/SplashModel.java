package com.example.gdte.tripko.splash;

import android.util.Log;

public class SplashModel implements SplashContract.Model {

    public static String TAG = SplashModel.class.getSimpleName();

    public SplashModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
