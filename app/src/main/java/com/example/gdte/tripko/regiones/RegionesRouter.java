package com.example.gdte.tripko.regiones;

import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class RegionesRouter implements RegionesContract.Router {

    public static String TAG = RegionesRouter.class.getSimpleName();

    private AppMediator mediator;

    public RegionesRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, RegionesActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(RegionesState state) {
        mediator.setRegionesState(state);
    }

    @Override
    public RegionesState getStateFromNextScreen() {
        return mediator.getRegionesState();
    }
}
