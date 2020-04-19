package com.example.gdte.tripko.idiomacoreano;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Idioma_CoreanoRouter implements Idioma_CoreanoContract.Router {

    public static String TAG = Idioma_CoreanoRouter.class.getSimpleName();

    private AppMediator mediator;

    public Idioma_CoreanoRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Idioma_CoreanoActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(Idioma_CoreanoState state) {
        mediator.setIdiomaCoreanoState(state);
    }

    @Override
    public Idioma_CoreanoState getDataFromPreviousScreen() {
        Idioma_CoreanoState state = mediator.getIdiomaCoreanoState();
        return state;
    }
}
