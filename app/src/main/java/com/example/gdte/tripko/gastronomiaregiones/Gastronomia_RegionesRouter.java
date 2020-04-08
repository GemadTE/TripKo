package com.example.gdte.tripko.gastronomiaregiones;

import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.gastronomialist.GastronomiaListActivity;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;

public class Gastronomia_RegionesRouter implements Gastronomia_RegionesContract.Router {

    public static String TAG = Gastronomia_RegionesRouter.class.getSimpleName();

    private AppMediator mediator;

    public Gastronomia_RegionesRouter(AppMediator mediator) {
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
    public void passStateToNextScreen(Gastronomia_RegionesState state) {
        mediator.setGastronomiaRegionesState(state);
    }

    @Override
    public Gastronomia_RegionesState getStateFromNextScreen() {
        return mediator.getGastronomiaRegionesState();
    }
}
