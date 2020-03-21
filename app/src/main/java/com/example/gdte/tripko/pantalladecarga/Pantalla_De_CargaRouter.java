package com.example.gdte.tripko.pantalladecarga;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Pantalla_De_CargaRouter implements Pantalla_De_CargaContract.Router {

    public static String TAG = Pantalla_De_CargaRouter.class.getSimpleName();

    private AppMediator mediator;

    public Pantalla_De_CargaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Pantalla_De_CargaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(Pantalla_De_CargaState state) {
        mediator.setPantalla_De_CargaState(state);
    }

    @Override
    public Pantalla_De_CargaState getDataFromPreviousScreen() {
        Pantalla_De_CargaState state = mediator.getPantalla_De_CargaState();
        return state;
    }
}
