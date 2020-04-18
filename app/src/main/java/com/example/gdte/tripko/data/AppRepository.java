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

    private static AppRepository INSTANCE;

    private Context context;
    private List<RegionItem> regiones;

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
}
