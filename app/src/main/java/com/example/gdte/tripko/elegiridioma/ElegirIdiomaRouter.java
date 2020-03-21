package com.example.gdte.tripko.elegiridioma;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class ElegirIdiomaRouter implements ElegirIdiomaContract.Router {

    public static String TAG = ElegirIdiomaRouter.class.getSimpleName();

    private AppMediator mediator;

    public ElegirIdiomaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ElegirIdiomaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ElegirIdiomaState state) {
        mediator.setElegirIdiomaState(state);
    }

    @Override
    public ElegirIdiomaState getDataFromPreviousScreen() {
        ElegirIdiomaState state = mediator.getElegirIdiomaState();
        return state;
    }
}
