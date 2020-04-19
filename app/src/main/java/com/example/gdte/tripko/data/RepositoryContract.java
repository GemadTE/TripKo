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

    //CULTURA
    void loadCultura(final FetchCulturaDataCallback callback);

    void getCultura(final int id, final GetCulturaCallback callback);

    void getCulturaList(final GetCulturaListCallback callback);

    interface FetchCulturaDataCallback {
        void onCulturaDataFetched(boolean error);
    }

    interface GetCulturaListCallback {
        void setCulturaList(List<CulturaItem> loadCultura);
    }

    interface GetCulturaCallback {
        void setCultura(CulturaItem cultura);
    }

    //ENTRETENIMIENTO
    void loadEntretenimiento(final FetchEntretenimientoDataCallback callback);

    void getEntretenimientoDetailList(
            final EntretenimientoItem entretenimientoItem,
            final GetEntretenimientoDetailListCallback callback);

    void getEntretenimientoDetailList(
            final int entretenimientoId, final GetEntretenimientoDetailListCallback callback);

    void getEntretenimientoDetail(final int id, final GetEntretenimientoDetailCallback callback);

    void getEntretenimiento(final int id, final GetEntretenimientoCallback callback);

    void getEntretenimientoList(final GetEntretenimientoListCallback callback);


    interface FetchEntretenimientoDataCallback {
        void onEntretenimientoDataFetched(boolean error);
    }

    interface GetEntretenimientoDetailListCallback {
        void setEntretenimientoDetailList(List<EntretenimientoDetailItem> entretenimientoDetailList);
    }

    interface GetEntretenimientoDetailCallback {
        void setEntretenimientoDetail(EntretenimientoDetailItem loadEntretenimientoDetail);
    }

    interface GetEntretenimientoListCallback {
        void setEntretenimientoList(List<EntretenimientoItem> loadEntretenimiento);
    }

    interface GetEntretenimientoCallback {
        void setEntretenimiento(EntretenimientoItem entretenimiento);
    }


    //////////////////////////////////////////Sitios Turisticos//////////////////////////


    interface FetchSitioTuristicoDataCallback {
        void onSitiosTuristicosDataFetched(boolean error);
    }

    interface GetSitioTuristicoDetailListCallback {
        void setSitioTuristicoDetailList(List<Sitios_TuristicosDetailItem> sitioTuristicoDetailItem);
    }

    interface GetSitioTuristicoDetailCallback {
        void setSitioTuristicoDetai(Sitios_TuristicosDetailItem sitioTuristicoDetailItem);
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
