package com.example.gdte.tripko.ciudadesprincipales;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class Ciudades_PrincipalesRouter implements Ciudades_PrincipalesContract.Router {

    public static String TAG = Ciudades_PrincipalesRouter.class.getSimpleName();

    private AppMediator mediator;

    public Ciudades_PrincipalesRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Ciudades_PrincipalesActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(Ciudades_PrincipalesState state) {
        mediator.setCiudades_PrincipalesState(state);
    }

    @Override
    public Ciudades_PrincipalesState getDataFromPreviousScreen() {
        Ciudades_PrincipalesState state = mediator.getCiudades_PrincipalesState();
        return state;
    }
}
