package com.example.gdte.tripko.gastronomialist;

import android.util.Log;

import com.example.gdte.tripko.data.GastronomiaDetailItem;
import com.example.gdte.tripko.data.GastronomiaItem;
import com.example.gdte.tripko.data.RegionItem;
import com.example.gdte.tripko.data.RepositoryContract;

import java.util.ArrayList;
import java.util.List;

public class GastronomiaListModel implements GastronomiaListContract.Model {

    public static String TAG = GastronomiaListModel.class.getSimpleName();

    private final List<GastronomiaItem> itemList = new ArrayList<>();
    private RepositoryContract repository;

    public GastronomiaListModel(RepositoryContract repository) {
       this.repository = repository;
    }

    @Override
    public void fetchGastronomiaListData(
            RegionItem region, RepositoryContract.GetGastronomiaListCallback callback) {

        Log.e(TAG, "fetchProductListData()");
        repository.getGastronomiaList(region, callback);
    }
}
