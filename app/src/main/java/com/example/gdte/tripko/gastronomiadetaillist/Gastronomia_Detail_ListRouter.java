package com.example.gdte.tripko.gastronomiadetaillist;

import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class Gastronomia_Detail_ListRouter implements Gastronomia_Detail_ListContract.Router {

    public static String TAG = Gastronomia_Detail_ListRouter.class.getSimpleName();

    private AppMediator mediator;

    public Gastronomia_Detail_ListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void passStateToNextScreen(Gastronomia_Detail_ListState state) {
        mediator.setComidarestaurantedetailState(state);
    }

    @Override
    public void passStateToPreviousScreen(Gastronomia_Detail_ListState state) {
        mediator.setComidarestaurantedetailState(state);
    }

    @Override
    public Gastronomia_Detail_ListState getStateFromPreviousScreen() {
        return mediator.getComidarestaurantedetailState();
    }

    @Override
    public Gastronomia_Detail_ListState getStateFromNextScreen() {
        return mediator.getComidarestaurantedetailState();
    }
}
