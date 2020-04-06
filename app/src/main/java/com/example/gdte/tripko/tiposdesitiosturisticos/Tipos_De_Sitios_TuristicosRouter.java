package com.example.gdte.tripko.tiposdesitiosturisticos;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Tipos_De_Sitios_TuristicosRouter implements Tipos_De_Sitios_TuristicosContract.Router {

    public static String TAG = Tipos_De_Sitios_TuristicosRouter.class.getSimpleName();

    private AppMediator mediator;

    public Tipos_De_Sitios_TuristicosRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Tipos_De_Sitios_TuristicosActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(Tipos_De_Sitios_TuristicosState state) {
        mediator.setTiposDeSitiosTuristicosState(state);
    }

    @Override
    public Tipos_De_Sitios_TuristicosState getDataFromPreviousScreen() {
        Tipos_De_Sitios_TuristicosState state = mediator.getTiposDeSitiosTuristicosState();
        return state;
    }
}
