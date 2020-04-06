package com.example.gdte.tripko.clima;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class ClimaRouter implements ClimaContract.Router {

    public static String TAG = ClimaRouter.class.getSimpleName();

    private AppMediator mediator;

    public ClimaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ClimaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ClimaState state) {
        mediator.setClimaState(state);
    }

    @Override
    public ClimaState getDataFromPreviousScreen() {
        ClimaState state = mediator.getClimaState();
        return state;
    }
}
