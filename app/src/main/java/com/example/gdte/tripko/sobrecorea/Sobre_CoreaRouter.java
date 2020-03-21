package com.example.gdte.tripko.sobrecorea;

import android.util.Log;
import android.content.Intent;
import android.content.Context;
import com.example.gdte.tripko.app.AppMediator;

public class Sobre_CoreaRouter implements Sobre_CoreaContract.Router {

    public static String TAG = Sobre_CoreaRouter.class.getSimpleName();

    private AppMediator mediator;

    public Sobre_CoreaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Sobre_CoreaActivity.class);
        context.startActivity(intent);
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
