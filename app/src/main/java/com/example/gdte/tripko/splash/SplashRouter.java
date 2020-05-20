package com.example.gdte.tripko.splash;

import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.elegiridioma.Elegir_IdiomaActivity;

public class SplashRouter implements SplashContract.Router {

    public static String TAG = SplashRouter.class.getSimpleName();

    private AppMediator mediator;

    public SplashRouter(AppMediator mediator) {
        this.mediator = mediator;
    }


}
