package com.example.gdte.tripko.idiomaalfabeto;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Idioma_AlfabetoRouter implements Idioma_AlfabetoContract.Router {

    public static String TAG = Idioma_AlfabetoRouter.class.getSimpleName();

    private AppMediator mediator;

    public Idioma_AlfabetoRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Idioma_AlfabetoActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(Idioma_AlfabetoState state) {
        mediator.setIdiomaAlfabetoState(state);
    }

    @Override
    public Idioma_AlfabetoState getDataFromPreviousScreen() {
        Idioma_AlfabetoState state = mediator.getIdiomaAlfabetoState();
        return state;
    }
}
