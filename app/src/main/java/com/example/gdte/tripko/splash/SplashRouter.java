package com.example.gdte.tripko.splash;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.elegiridioma.ElegirIdiomaActivity;

public class SplashRouter implements SplashContract.Router {

    public static String TAG = SplashRouter.class.getSimpleName();

    private AppMediator mediator;

    public SplashRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToChooseLanguageScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ElegirIdiomaActivity.class);
        context.startActivity(intent);
    }
}
