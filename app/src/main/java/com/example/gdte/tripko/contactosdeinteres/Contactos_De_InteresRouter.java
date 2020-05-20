package com.example.gdte.tripko.contactosdeinteres;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Contactos_De_InteresRouter implements Contactos_De_InteresContract.Router {

    public static String TAG = Contactos_De_InteresRouter.class.getSimpleName();

    private AppMediator mediator;

    public Contactos_De_InteresRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void passStateToNextScreen(Contactos_De_InteresState state) {
        mediator.setContactosDeInteresState(state);
    }

    @Override
    public void passStateToPreviousScreen(Contactos_De_InteresState state) {
        mediator.setContactosDeInteresState(state);
    }

    @Override
    public Contactos_De_InteresState getStateFromPreviousScreen() {
        return mediator.getContactosDeInteresState();
    }

    @Override
    public Contactos_De_InteresState getStateFromNextScreen() {
        return mediator.getContactosDeInteresState();
    }
}
