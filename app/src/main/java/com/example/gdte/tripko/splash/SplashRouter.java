package com.example.gdte.tripko.splash;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.elegiridioma.Pantalla_De_CargaActivity;

public class SplashRouter implements SplashContract.Router {

    public static String TAG = SplashRouter.class.getSimpleName();

    private AppMediator mediator;

    public SplashRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToChooseLanguageScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Pantalla_De_CargaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(SplashState state) {
        mediator.setSplashState(state);
    }

    @Override
    public SplashState getDataFromPreviousScreen() {
        SplashState state = mediator.getSplashState();
        return state;
    }
}
