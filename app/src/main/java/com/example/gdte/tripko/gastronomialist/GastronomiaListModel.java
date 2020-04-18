package com.example.gdte.tripko.gastronomialist;

import android.util.Log;

import com.example.gdte.tripko.data.GastronomiaDetailItem;
import com.example.gdte.tripko.data.GastronomiaItem;

import java.util.ArrayList;
import java.util.List;

public class GastronomiaListModel implements GastronomiaListContract.Model {

    public static String TAG = GastronomiaListModel.class.getSimpleName();

    private final List<GastronomiaItem> itemList = new ArrayList<>();
    private final int COUNT = 2;

    public GastronomiaListModel() {
        for (int index = 1; index <= COUNT; index++) {
            addGastronomia(createGastronomia(index));
        }
    }

    @Override
    public List<GastronomiaItem> fetchProductListData() {
        Log.e(TAG, "fetchProductListData()");
        return itemList;
    }

    private void addGastronomia(GastronomiaItem item) {
        itemList.add(item);
    }

    private GastronomiaItem createGastronomia(int position) {
        String content = "Restaurante " + position;

        return new GastronomiaItem(position,content);

    }
}
