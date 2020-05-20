package com.example.gdte.tripko.cultura;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class CulturaRouter implements CulturaContract.Router {

    public static String TAG = CulturaRouter.class.getSimpleName();

    private AppMediator mediator;

    public CulturaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }


    @Override
    public void passDataToNextScreen(CulturaState state) {
        mediator.setCulturaState(state);
    }

    @Override
    public CulturaState getDataFromPreviousScreen() {
        CulturaState state = mediator.getCulturaState();
        return state;
    }
}
