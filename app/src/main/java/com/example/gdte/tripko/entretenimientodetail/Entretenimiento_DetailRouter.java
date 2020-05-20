package com.example.gdte.tripko.entretenimientodetail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class Entretenimiento_DetailRouter implements Entretenimiento_DetailContract.Router {

    public static String TAG = Entretenimiento_DetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public Entretenimiento_DetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }


    @Override
    public void passStateToNextScreen(Entretenimiento_DetailState state) {
        mediator.setEntretenimientoDetailState(state);
    }

    @Override
    public void passStateToPreviousScreen(Entretenimiento_DetailState state) {
        mediator.setEntretenimientoDetailState(state);
    }

    @Override
    public Entretenimiento_DetailState getStateFromPreviousScreen() {
        return mediator.getEntretenimientoDetailState();
    }

    @Override
    public Entretenimiento_DetailState getStateFromNextScreen() {
        return mediator.getEntretenimientoDetailState();
    }
}
