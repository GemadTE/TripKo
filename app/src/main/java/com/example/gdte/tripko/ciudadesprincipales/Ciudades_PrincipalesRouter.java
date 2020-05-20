package com.example.gdte.tripko.ciudadesprincipales;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class Ciudades_PrincipalesRouter implements Ciudades_PrincipalesContract.Router {

    public static String TAG = Ciudades_PrincipalesRouter.class.getSimpleName();

    private AppMediator mediator;

    public Ciudades_PrincipalesRouter(AppMediator mediator) {
        this.mediator = mediator;
    }


}

