package com.example.gdte.tripko.elegiridioma;

import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;

public class Elegir_IdiomaRouter implements Elegir_IdiomaContract.Router {

    public static String TAG = Elegir_IdiomaRouter.class.getSimpleName();

    private AppMediator mediator;

    public Elegir_IdiomaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void passDataToMenuScreen(Elegir_IdiomaState state) {
        mediator.setElegirIdiomaState(state);
    }
}
