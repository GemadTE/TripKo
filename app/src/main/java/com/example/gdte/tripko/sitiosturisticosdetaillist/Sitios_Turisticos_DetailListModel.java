package com.example.gdte.tripko.sitiosturisticosdetaillist;

import android.util.Log;

import com.example.gdte.tripko.data.RepositoryContract;
import com.example.gdte.tripko.data.Sitios_TuristicosItem;

public class Sitios_Turisticos_DetailListModel implements Sitios_Turisticos_DetailListContract.Model {

    public static String TAG = Sitios_Turisticos_DetailListModel.class.getSimpleName();

    private RepositoryContract repository;


    public Sitios_Turisticos_DetailListModel(RepositoryContract repository) {
        this.repository = repository;
    }

    @Override
    public void fetchSitiosTuristicosListData(
            Sitios_TuristicosItem sitios_turisticosItem, RepositoryContract.GetSitioTuristicoDetailListCallback callback) {


        repository.getSitioTuristicoDetailList(sitios_turisticosItem, callback);
    }
}
