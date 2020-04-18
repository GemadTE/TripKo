package com.example.gdte.tripko.idioma;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class IdiomaRouter implements IdiomaContract.Router {

    public static String TAG = IdiomaRouter.class.getSimpleName();

    private AppMediator mediator;

    public IdiomaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, IdiomaActivity.class);
        context.startActivity(intent);
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
