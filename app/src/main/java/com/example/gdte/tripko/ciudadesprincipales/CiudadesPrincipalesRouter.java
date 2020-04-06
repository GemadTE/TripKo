package com.example.gdte.tripko.ciudadesprincipales;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class CiudadesPrincipalesRouter implements CiudadesPrincipalesContract.Router {

    public static String TAG = CiudadesPrincipalesRouter.class.getSimpleName();

    private AppMediator mediator;

    public CiudadesPrincipalesRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, CiudadesPrincipalesActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(CiudadesPrincipalesState state) {
        mediator.setCiudadesPrincipalesState(state);
    }

    @Override
    public CiudadesPrincipalesState getDataFromPreviousScreen() {
        CiudadesPrincipalesState state = mediator.getCiudadesPrincipalesState();
        return state;
    }
}
