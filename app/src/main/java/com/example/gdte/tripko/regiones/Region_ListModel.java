package com.example.gdte.tripko.regiones;

import com.example.gdte.tripko.data.RepositoryContract;

public class Region_ListModel implements Region_ListContract.Model {

    public static String TAG = Region_ListModel.class.getSimpleName();

 private RepositoryContract repository;

    public Region_ListModel(RepositoryContract repository) {
        this.repository = repository;
    }

    @Override
    public void fetchRegionListData(
            final RepositoryContract.GetRegionListCallback callback){

        repository.loadRegiones(new RepositoryContract.FetchRegionesDataCallback() {

            @Override
            public void onRegionesDataFetched(boolean error) {
                if(!error){
                    repository.getRegionList(callback);
                }
            }
        });
    }
}
