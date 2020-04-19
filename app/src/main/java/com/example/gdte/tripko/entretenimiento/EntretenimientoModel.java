package com.example.gdte.tripko.entretenimiento;

import android.util.Log;

import com.example.gdte.tripko.data.RepositoryContract;

public class EntretenimientoModel implements EntretenimientoContract.Model {

    public static String TAG = EntretenimientoModel.class.getSimpleName();

    private RepositoryContract repository;

    public EntretenimientoModel(RepositoryContract repository) {
        this.repository = repository;
    }

    @Override
    public void fetchEntretenimientoListData(
            final RepositoryContract.GetEntretenimientoListCallback callback) {

        repository.loadEntretenimiento(new RepositoryContract.FetchEntretenimientoDataCallback() {

            @Override
            public void onEntretenimientoDataFetched(boolean error) {
                if (!error) {
                    repository.getEntretenimientoList(callback);
                }
            }
        });

    }
}
