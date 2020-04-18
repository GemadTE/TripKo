package com.example.gdte.tripko.data;

import java.util.List;

public interface RepositoryContract {

    interface FetchRegionesDataCallback {
        void onRegionesDataFetched(boolean error);
    }

    interface GetGastronomiaListCallback {
        void setGastronomiaList(List<GastronomiaItem> gastronomiaItems);
    }

    interface GetGastronomiatCallback {
        void setGastronomia(GastronomiaItem gastronomia);
    }

    interface GetRegionListCallback {
        void setRegionList(List<RegionItem> regions);
    }

    interface GetRegionCallback {
        void setRegion(RegionItem regiones);
    }


    void loadRegiones(AppRepository.FetchRegionesDataCallback callback);

    void getGastronomiaList(
            RegionItem category, AppRepository.GetGastronomiaListCallback callback);

    void getGastronomiaList(
            int categoryId, AppRepository.GetGastronomiaListCallback callback);

    void getGastronomia(int id, AppRepository.GetGastronomiatCallback callback);
    void getRegion(int id, AppRepository.GetRegionCallback callback);
    void getRegionList(AppRepository.GetRegionListCallback callback);
}
