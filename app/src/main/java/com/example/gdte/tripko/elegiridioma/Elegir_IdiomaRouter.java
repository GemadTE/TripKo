package com.example.gdte.tripko.elegiridioma;

import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Elegir_IdiomaRouter implements Elegir_IdiomaContract.Router {

    public static String TAG = Elegir_IdiomaRouter.class.getSimpleName();

    private AppMediator mediator;

    public Elegir_IdiomaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Elegir_IdiomaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(Elegir_IdiomaState state) {
        mediator.setElegirIdiomaState(state);
    }

    @Override
    public Elegir_IdiomaState getDataFromPreviousScreen() {
        Elegir_IdiomaState state = mediator.getElegirIdiomaState();
        return state;
    }
}
