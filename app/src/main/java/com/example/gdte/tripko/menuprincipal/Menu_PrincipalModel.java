package com.example.gdte.tripko.menuprincipal;

import android.util.Log;

public class Menu_PrincipalModel implements Menu_PrincipalContract.Model {

    public static String TAG = Menu_PrincipalModel.class.getSimpleName();

    public Menu_PrincipalModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
