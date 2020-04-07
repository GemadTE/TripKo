package com.example.gdte.tripko.gastronomiadetaillist;

import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Gastronomia_Detail_ListRouter implements Gastronomia_Detail_ListContract.Router {

    public static String TAG = Gastronomia_Detail_ListRouter.class.getSimpleName();

    private AppMediator mediator;

    public Gastronomia_Detail_ListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Gastronomia_Detail_ListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(Gastronomia_Detail_ListState state) {
        mediator.setComidarestaurantedetailState(state);
    }

    @Override
    public void passStateToPreviousScreen(Gastronomia_Detail_ListState state) {
        mediator.setComidarestaurantedetailState(state);
    }

    @Override
    public Gastronomia_Detail_ListState getStateFromPreviousScreen() {
        return mediator.getComidarestaurantedetailState();
    }

    @Override
    public Gastronomia_Detail_ListState getStateFromNextScreen() {
        return mediator.getComidarestaurantedetailState();
    }
}
