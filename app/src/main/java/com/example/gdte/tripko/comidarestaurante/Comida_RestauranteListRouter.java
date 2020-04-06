package com.example.gdte.tripko.comidarestaurante;

import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Comida_RestauranteListRouter implements Comida_RestauranteListContract.Router {

    public static String TAG = Comida_RestauranteListRouter.class.getSimpleName();

    private AppMediator mediator;

    public Comida_RestauranteListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Comida_RestauranteListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(Comida_RestauranteListState state) {
        mediator.setComidaRestauranteListState(state);
    }

    @Override
    public void passStateToPreviousScreen(Comida_RestauranteListState state) {
        mediator.setComidaRestauranteListState(state);
    }

    @Override
    public Comida_RestauranteListState getStateFromPreviousScreen() {
        return mediator.getComidaRestauranteListState();
    }

    @Override
    public Comida_RestauranteListState getStateFromNextScreen() {
        return mediator.getComidaRestauranteListState();
    }
}
