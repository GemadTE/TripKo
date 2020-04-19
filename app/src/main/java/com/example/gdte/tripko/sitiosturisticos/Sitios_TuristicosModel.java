package com.example.gdte.tripko.sitiosturisticos;

import android.util.Log;

import com.example.gdte.tripko.data.RepositoryContract;

public class Sitios_TuristicosModel implements Sitios_TuristicosContract.Model {

    public static String TAG = Sitios_TuristicosModel.class.getSimpleName();

    private RepositoryContract repository;

    public Sitios_TuristicosModel(RepositoryContract repository) {
        this.repository = repository;
    }

    @Override
    public void fetchSitioTuristicoListData(
            final RepositoryContract.GetSitioTuristicoListCallback callback) {

        Log.e(TAG, "fetchCategoryListData()");

        repository.loadSitioTuristico(new RepositoryContract.FetchSitioTuristicoDataCallback() {

            @Override
            public void onSitiosTuristicosDataFetched(boolean error) {
                if (!error) {
                    repository.getSitioTuristicoList(callback);
                }
            }
        });

    }
}
