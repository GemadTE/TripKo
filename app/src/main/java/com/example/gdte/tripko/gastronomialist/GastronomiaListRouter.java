package com.example.gdte.tripko.gastronomialist;

import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;

public class GastronomiaListRouter implements GastronomiaListContract.Router {

    public static String TAG = GastronomiaListRouter.class.getSimpleName();

    private AppMediator mediator;

    public GastronomiaListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, GastronomiaListActivity.class);
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
    public void passStateToNextScreen(GastronomiaListState state) {
        mediator.setComidaRestauranteListState(state);
    }

    @Override
    public void passStateToPreviousScreen(GastronomiaListState state) {
        mediator.setComidaRestauranteListState(state);
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
