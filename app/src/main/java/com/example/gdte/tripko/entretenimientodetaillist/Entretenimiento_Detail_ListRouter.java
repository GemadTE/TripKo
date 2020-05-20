package com.example.gdte.tripko.entretenimientodetaillist;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class Entretenimiento_Detail_ListRouter implements Entretenimiento_Detail_ListContract.Router {

    public static String TAG = Entretenimiento_Detail_ListRouter.class.getSimpleName();

    private AppMediator mediator;

    public Entretenimiento_Detail_ListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void passStateToNextScreen(Entretenimiento_Detail_ListState state) {
        mediator.setEntretenimientoDetailListState(state);
    }

    @Override
    public void passStateToPreviousScreen(Entretenimiento_Detail_ListState state) {
        mediator.setEntretenimientoDetailListState(state);
    }

    @Override
    public Entretenimiento_Detail_ListState getStateFromPreviousScreen() {
        return mediator.getEntretenimientoDetailListState();
    }

    @Override
    public Entretenimiento_Detail_ListState getStateFromNextScreen() {
        return mediator.getEntretenimientoDetailListState();
    }
}
