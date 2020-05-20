package com.example.gdte.tripko.clima;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class ClimaRouter implements ClimaContract.Router {

    public static String TAG = ClimaRouter.class.getSimpleName();

    private AppMediator mediator;

    public ClimaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

}
