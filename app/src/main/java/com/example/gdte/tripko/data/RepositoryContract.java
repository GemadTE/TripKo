package com.example.gdte.tripko.data;

import java.util.List;

public interface RepositoryContract {

    /////////////////////////////////////////////////Regiones////////////////////////////////////////////////////////////////777

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


    //////////////////////////////////////////Sitios Turisticos//////////////////////////


    interface FetchSitioTuristicoDataCallback {
        void onSitiosTuristicosDataFetched(boolean error);
    }

    interface GetSitioTuristicoDetailListCallback {
        void setSitioTuristicoDetailList(List<SitiosTuristicosDetailItem> sitioTuristicoDetailItem);
    }

    interface GetSitioTuristicoDetailCallback {
        void setSitioTuristicoDetai(SitiosTuristicosDetailItem sitioTuristicoDetailItem);
    }

    interface GetSitioTuristicoListCallback {
        void setSitioTuristicoList(List<Sitios_TuristicosItem> sitiosTuristicosItems);
    }

    interface GetSitioTuristicoCallback {
        void setSitioTuristico(Sitios_TuristicosItem sitiosTuristicosItem);
    }


    void loadSitioTuristico(AppRepository.FetchSitioTuristicoDataCallback callback);

    void getSitioTuristicoDetailList(
            Sitios_TuristicosItem sitiosTuristicosItem, AppRepository.GetSitioTuristicoDetailListCallback callback);

    void getSitioTuristicoDetailList(
            int categoryId, AppRepository.GetSitioTuristicoDetailListCallback callback);

    void getSitioTuristicoDetail(int id, AppRepository.GetSitioTuristicoDetailCallback callback);
    void getSitioTuristico(int id, AppRepository.GetSitioTuristicoCallback callback);
    void getSitioTuristicoList(AppRepository.GetSitioTuristicoListCallback callback);

}
