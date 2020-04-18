package com.example.gdte.tripko.gastronomialist;

import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.data.GastronomiaItem;
import com.example.gdte.tripko.data.RegionItem;
import com.example.gdte.tripko.gastronomiadetaillist.Gastronomia_Detail_ListActivity;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;

public class GastronomiaListRouter implements GastronomiaListContract.Router {

    public static String TAG = GastronomiaListRouter.class.getSimpleName();

    private AppMediator mediator;

    public GastronomiaListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToGastronomiaDetailListScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Gastronomia_Detail_ListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void navigateToHomeScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Menu_PrincipalActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passDataToGastronomiaDetailListScreen(GastronomiaItem item) {
        mediator.setGastronomiaItem(item);
    }

    @Override
    public RegionItem getDataFromRegionListScreen() {
        RegionItem region = mediator.getRegionItem();
        return region;
    }

    @Override
    public GastronomiaListState getStateFromPreviousScreen() {
        return mediator.getComidaRestauranteListState();
    }

    @Override
    public GastronomiaListState getStateFromNextScreen() {
        return mediator.getComidaRestauranteListState();
    }
}
