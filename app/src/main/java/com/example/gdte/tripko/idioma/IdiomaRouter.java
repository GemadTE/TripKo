package com.example.gdte.tripko.idioma;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.expresionesdetaillist.Expresiones_Detail_ListActivity;
import com.example.gdte.tripko.idiomaalfabeto.Idioma_AlfabetoActivity;
import com.example.gdte.tripko.idiomacoreano.Idioma_CoreanoActivity;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class IdiomaRouter implements IdiomaContract.Router {

    public static String TAG = IdiomaRouter.class.getSimpleName();

    private AppMediator mediator;

    public IdiomaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }



    @Override
    public void passDataToNextScreen(IdiomaState state) {
        mediator.setIdiomaState(state);
    }

    @Override
    public IdiomaState getDataFromPreviousScreen() {
        IdiomaState state = mediator.getIdiomaState();
        return state;
    }
}
