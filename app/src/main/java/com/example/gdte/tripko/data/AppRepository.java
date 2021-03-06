package com.example.gdte.tripko.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppRepository implements RepositoryContract {

    public static String TAG = AppRepository.class.getSimpleName();

    public static final String JSON_FILE = "Data.json";
    public static final String JSON_ROOT = "regiones";
    public static final String JSON_CULTURA = "cultura";
    public static final String JSON_ENTRETENIMIENTO = "entretenimiento";
    public static final String JSON_SITIOS_TURISTICOS = "sitiosTuristicos";
    private static AppRepository INSTANCE;

    private Context context;
    private List<RegionItem> regiones;
    private List<CulturaItem> culturaItems;
    private List<EntretenimientoItem> entretenimientoItems;
    private List<Sitios_TuristicosItem> sitios_turisticosItems;

    public static RepositoryContract getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new AppRepository(context);
        }

        return INSTANCE;
    }

    private AppRepository(Context context) {
        this.context = context;
    }

    @Override
    public void loadRegiones(final FetchRegionesDataCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                boolean error = !loadRegionFromJSON(loadJSONFromAsset());

                if (callback != null) {
                    callback.onRegionesDataFetched(error);
                }
            }
        });
    }

    @Override
    public void getGastronomiaList(
            final RegionItem region, final GetGastronomiaListCallback callback) {

        getGastronomiaList(region.id, callback);
    }

    @Override
    public void getGastronomiaList(
            final int regionId, final GetGastronomiaListCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setGastronomiaList(loadGastronomiaList(regionId));
                }
            }
        });

    }

    @Override
    public void getGastronomia(final int id, final GetGastronomiatCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setGastronomia(loadGastronomia(id));
                }
            }
        });
    }

    @Override
    public void getRegion(final int id, final GetRegionCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setRegion(loadRegion(id));
                }
            }


        });

    }

    @Override
    public void getRegionList(final GetRegionListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setRegionList(loadRegiones());

                }
            }
        });

    }

    private boolean loadRegionFromJSON(String json) {
        Log.e(TAG, "loadRegionFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

            regiones = new ArrayList();

            if (jsonArray.length() > 0) {

                final List<RegionItem> regiones = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), RegionItem[].class)
                );


                for (RegionItem region : regiones) {
                    insertRegiones(region);
                }

                for (RegionItem region : regiones) {
                    for (GastronomiaItem gastronomiaItem : region.gastronomiaItemList) {
                        gastronomiaItem.regionesId = region.id;

                    }
                }

                for (RegionItem region : regiones) {
                    for (GastronomiaItem gastronomiaItem : region.gastronomiaItemList) {
                        for (GastronomiaDetailItem gastronomiaDetailItem : gastronomiaItem.items) {
                            gastronomiaDetailItem.gastronomiaId = gastronomiaItem.id;
                        }
                    }
                }

                return true;
            }

        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }

        return false;
    }

    private String loadJSONFromAsset() {
        //Log.e(TAG, "loadJSONFromAsset()");

        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }

        return json;
    }

    private List<GastronomiaDetailItem> loadGastronomiaDetailList(int gastronomiaId) {

        List<GastronomiaDetailItem> gastronomiaDetailItems = new ArrayList();

        for (RegionItem region : regiones) {
            for (GastronomiaItem gastronomiaItem : region.gastronomiaItemList) {
                if (gastronomiaItem.id == gastronomiaId) {
                    gastronomiaDetailItems = gastronomiaItem.items;
                }
            }
        }

        return gastronomiaDetailItems;
    }


    private List<GastronomiaItem> loadGastronomiaList(int regionesId) {

        List<GastronomiaItem> gastronomiaItems = new ArrayList();

        for (RegionItem region : regiones) {
            if (region.id == regionesId) {
                gastronomiaItems = region.gastronomiaItemList;
            }
        }

        return gastronomiaItems;
    }

    private GastronomiaDetailItem loadGastronomiaDetail(int id) {
        for (RegionItem region : regiones) {
            for (GastronomiaItem gastronomiaItem : region.gastronomiaItemList) {
                for (GastronomiaDetailItem gastronomiaDetailItem : gastronomiaItem.items) {
                    if (gastronomiaDetailItem.id == id) {
                        return gastronomiaDetailItem;
                    }
                }
            }
        }

        return null;
    }

    private GastronomiaItem loadGastronomia(int id) {
        for (RegionItem region : regiones) {
            for (GastronomiaItem gastronomiaItem : region.gastronomiaItemList) {
                if (gastronomiaItem.id == id) {
                    return gastronomiaItem;
                }
            }
        }

        return null;
    }

    private RegionItem loadRegion(int id) {
        for (RegionItem region : regiones) {
            if (region.id == id) {
                return region;
            }
        }

        return null;
    }

    private void insertRegiones(RegionItem region) {
        regiones.add(region);
    }


    private List<RegionItem> loadRegiones() {
        return regiones;
    }

    ///////////////////////////////////////////CULTURA//////////////////////////////////////////////
    @Override
    public void loadCultura(final FetchCulturaDataCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                boolean error = !loadCulturaFromJSON(loadJSONFromAsset());

                if (callback != null) {
                    callback.onCulturaDataFetched(error);
                }
            }
        });
    }

    @Override
    public void getCultura(final int id, final GetCulturaCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setCultura(loadCultura(id));
                }
            }


        });

    }

    @Override
    public void getCulturaList(final GetCulturaListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setCulturaList(loadCultura());

                }
            }
        });

    }

    private boolean loadCulturaFromJSON(String json) {
        Log.e(TAG, "loadCulturaFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_CULTURA);

            culturaItems = new ArrayList();

            if (jsonArray.length() > 0) {

                final List<CulturaItem> culturaItems = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), CulturaItem[].class)
                );


                for (CulturaItem cultura : culturaItems) {
                    insertCultura(cultura);
                }

                return true;
            }

        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }

        return false;
    }

    private CulturaItem loadCultura(int id) {
        for (CulturaItem cultura : culturaItems) {
            if (cultura.id == id) {
                return cultura;
            }
        }

        return null;
    }

    private void insertCultura(CulturaItem cultura) {
        culturaItems.add(cultura);
    }

    private List<CulturaItem> loadCultura() {
        return culturaItems;
    }

    /////////////////////////////////////////ENTRETENIMIENTO////////////////////////////////////////
    @Override
    public void loadEntretenimiento(final FetchEntretenimientoDataCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                boolean error = !loadEntretenimientoFromJSON(loadJSONFromAsset());
                if (callback != null) {
                    callback.onEntretenimientoDataFetched(error);
                }
            }
        });
    }

    @Override
    public void getEntretenimientoDetailList(
            final EntretenimientoItem entretenimientoItem, final GetEntretenimientoDetailListCallback callback) {

        getEntretenimientoDetailList(entretenimientoItem.id, callback);
    }


    @Override
    public void getEntretenimientoDetailList(
            final int entretenimientoId, final GetEntretenimientoDetailListCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setEntretenimientoDetailList(loadEntretenimientosDetail(entretenimientoId));
                }
            }
        });

    }


    @Override
    public void getEntretenimientoDetail(final int id, final GetEntretenimientoDetailCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setEntretenimientoDetail(loadEntretenimientoDetail(id));
                }
            }
        });
    }


    @Override
    public void getEntretenimiento(final int id, final GetEntretenimientoCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setEntretenimiento(loadEntretenimiento(id));
                }
            }


        });

    }


    @Override
    public void getEntretenimientoList(final GetEntretenimientoListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setEntretenimientoList(loadEntretenimiento());
                }
            }
        });

    }


    private boolean loadEntretenimientoFromJSON(String json) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ENTRETENIMIENTO);

            entretenimientoItems = new ArrayList();

            if (jsonArray.length() > 0) {

                final List<EntretenimientoItem> entretenimientoItems = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), EntretenimientoItem[].class)
                );


                for (EntretenimientoItem entretenimientoItem : entretenimientoItems) {
                    insertEntretenimiento(entretenimientoItem);
                }

                for (EntretenimientoItem entretenimientoItem : entretenimientoItems) {
                    for (EntretenimientoDetailItem entretenimientoDetailItem : entretenimientoItem.entretenimientoDetailItems) {
                        entretenimientoDetailItem.entretenimientoId = entretenimientoItem.id;

                    }
                }

                return true;
            }

        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }

        return false;
    }

    private List<EntretenimientoDetailItem> loadEntretenimientosDetail(int entretenimientoId) {
        List<EntretenimientoDetailItem> entretenimientoDetailItems = new ArrayList();

        for (EntretenimientoItem entretenimientoItem : entretenimientoItems) {
            if (entretenimientoItem.id == entretenimientoId) {
                entretenimientoDetailItems = entretenimientoItem.entretenimientoDetailItems;
            }
        }
        return entretenimientoDetailItems;
    }

    private EntretenimientoDetailItem loadEntretenimientoDetail(int id) {
        for (EntretenimientoItem entretenimientoItem : entretenimientoItems) {
            for (EntretenimientoDetailItem entretenimientoDetailItem : entretenimientoItem.entretenimientoDetailItems) {
                if (entretenimientoDetailItem.id == id) {
                    return entretenimientoDetailItem;
                }
            }
        }
        return null;
    }

    private EntretenimientoItem loadEntretenimiento(int id) {
        for (EntretenimientoItem entretenimientoItem : entretenimientoItems) {
            if (entretenimientoItem.id == id) {
                return entretenimientoItem;
            }
        }

        return null;
    }

    private void insertEntretenimiento(EntretenimientoItem entretenimientoItem) {
        entretenimientoItems.add(entretenimientoItem);
    }

    private List<EntretenimientoItem> loadEntretenimiento() {
        return entretenimientoItems;
    }


    //////////////////////////////////Sitios Turisticos//////////////////////////


    @Override
    public void loadSitioTuristico(final FetchSitioTuristicoDataCallback callback) {


        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {

                boolean error = !loadSitiosTuristicosFromJSON(loadJSONFromAsset());

                if (callback != null) {
                    callback.onSitiosTuristicosDataFetched(error);
                }
            }
        });

    }

    @Override
    public void getSitioTuristicoDetailList(
            final Sitios_TuristicosItem sitios_turisticosItem, final GetSitioTuristicoDetailListCallback callback) {

        getSitioTuristicoDetailList(sitios_turisticosItem.id, callback);
    }


    @Override
    public void getSitioTuristicoDetailList(
            final int sitiosTuristicosId, final GetSitioTuristicoDetailListCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setSitioTuristicoDetailList(loadSitiosTuristicosDetail(sitiosTuristicosId));
                }
            }
        });

    }


    @Override
    public void getSitioTuristicoDetail(final int id, final GetSitioTuristicoDetailCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setSitioTuristicoDetai(loadSitioTuristicoDetail(id));
                }
            }
        });
    }


    @Override
    public void getSitioTuristico(final int id, final GetSitioTuristicoCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setSitioTuristico(loadSitioTuristico(id));
                }
            }


        });

    }


    @Override
    public void getSitioTuristicoList(final GetSitioTuristicoListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setSitioTuristicoList(loadSitiosTuristicos());
                }
            }
        });

    }


    private boolean loadSitiosTuristicosFromJSON(String json) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_SITIOS_TURISTICOS);

            sitios_turisticosItems = new ArrayList();

            if (jsonArray.length() > 0) {

                final List<Sitios_TuristicosItem> sitiosTuristicosItems = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), Sitios_TuristicosItem[].class)
                );


                for (Sitios_TuristicosItem sitios_turisticosItem : sitiosTuristicosItems) {
                    insertSitioTuristico(sitios_turisticosItem);
                }

                for (Sitios_TuristicosItem sitios_turisticosItem : sitiosTuristicosItems) {
                    for (Sitios_TuristicosDetailItem sitiosTuristicosDetailItem : sitios_turisticosItem.sitiosTuristicosDetailItems) {
                        sitiosTuristicosDetailItem.sitiosTuristicosId = sitios_turisticosItem.id;

                    }
                }

                return true;
            }

        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }

        return false;
    }

    private List<Sitios_TuristicosDetailItem> loadSitiosTuristicosDetail(int sitioTuristicoId) {
        List<Sitios_TuristicosDetailItem> sitiosTuristicosDetailItems = new ArrayList();

        for (Sitios_TuristicosItem sitios_turisticosItem : sitios_turisticosItems) {
            if (sitios_turisticosItem.id == sitioTuristicoId) {
                sitiosTuristicosDetailItems = sitios_turisticosItem.sitiosTuristicosDetailItems;
            }
        }

        return sitiosTuristicosDetailItems;
    }

    private Sitios_TuristicosDetailItem loadSitioTuristicoDetail(int id) {
        for (Sitios_TuristicosItem sitios_turisticosItem : sitios_turisticosItems) {
            for (Sitios_TuristicosDetailItem sitiosTuristicosDetailItem : sitios_turisticosItem.sitiosTuristicosDetailItems) {
                if (sitiosTuristicosDetailItem.id == id) {
                    return sitiosTuristicosDetailItem;
                }
            }
        }

        return null;
    }

    private Sitios_TuristicosItem loadSitioTuristico(int id) {
        for (Sitios_TuristicosItem sitiosTuristicosItem : sitios_turisticosItems) {
            if (sitiosTuristicosItem.id == id) {
                return sitiosTuristicosItem;
            }
        }

        return null;
    }

    private void insertSitioTuristico(Sitios_TuristicosItem sitios_turisticosItem) {
        sitios_turisticosItems.add(sitios_turisticosItem);
    }

    private List<Sitios_TuristicosItem> loadSitiosTuristicos() {
        return sitios_turisticosItems;
    }
}
