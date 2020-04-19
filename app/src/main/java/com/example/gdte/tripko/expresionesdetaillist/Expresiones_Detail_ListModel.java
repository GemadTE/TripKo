package com.example.gdte.tripko.expresionesdetaillist;

import android.util.Log;

public class Expresiones_Detail_ListModel implements Expresiones_Detail_ListContract.Model {

    public static String TAG = Expresiones_Detail_ListModel.class.getSimpleName();

    public Expresiones_Detail_ListModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
