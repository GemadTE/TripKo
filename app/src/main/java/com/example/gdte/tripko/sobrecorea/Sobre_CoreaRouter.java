package com.example.gdte.tripko.sobrecorea;

import android.util.Log;
import android.content.Intent;
import android.content.Context;
import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.ciudadesprincipales.Ciudades_PrincipalesActivity;
import com.example.gdte.tripko.clima.ClimaActivity;
import com.example.gdte.tripko.cultura.CulturaActivity;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class Sobre_CoreaRouter implements Sobre_CoreaContract.Router {

    public static String TAG = Sobre_CoreaRouter.class.getSimpleName();

    private AppMediator mediator;

    public Sobre_CoreaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void passDataToNextScreen(Sobre_CoreaState state) {
        mediator.setSobre_CoreaState(state);
    }

    @Override
    public Sobre_CoreaState getDataFromPreviousScreen() {
        Sobre_CoreaState state = mediator.getSobre_CoreaState();
        return state;
    }
}
