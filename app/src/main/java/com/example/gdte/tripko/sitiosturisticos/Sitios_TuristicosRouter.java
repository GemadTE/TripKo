package com.example.gdte.tripko.sitiosturisticos;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class Sitios_TuristicosRouter implements Sitios_TuristicosContract.Router {

    public static String TAG = Sitios_TuristicosRouter.class.getSimpleName();

    private AppMediator mediator;

    public Sitios_TuristicosRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Sitios_TuristicosActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(Sitios_TuristicosState state) {
        mediator.setSitios_TuristicosState(state);
    }

    @Override
    public Sitios_TuristicosState getDataFromPreviousScreen() {
        Sitios_TuristicosState state = mediator.getSitios_TuristicosState();
        return state;
    }
}
