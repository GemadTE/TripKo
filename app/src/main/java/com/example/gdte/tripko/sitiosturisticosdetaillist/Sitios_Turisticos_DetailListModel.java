package com.example.gdte.tripko.sitiosturisticosdetaillist;

public class Sitios_Turisticos_DetailListModel implements Sitios_Turisticos_DetailListContract.Model {

    public static String TAG = Sitios_Turisticos_DetailListModel.class.getSimpleName();

    public Sitios_Turisticos_DetailListModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
