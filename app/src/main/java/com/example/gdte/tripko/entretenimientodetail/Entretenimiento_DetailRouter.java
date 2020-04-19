package com.example.gdte.tripko.entretenimientodetail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class Entretenimiento_DetailRouter implements Entretenimiento_DetailContract.Router {

    public static String TAG = Entretenimiento_DetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public Entretenimiento_DetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Entretenimiento_DetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(Entretenimiento_DetailState state) {
        mediator.setNextEntretenimiento_DetailScreenState(state);
    }

    @Override
    public void passStateToPreviousScreen(Entretenimiento_DetailState state) {
        mediator.setPreviousEntretenimiento_DetailScreenState(state);
    }

    @Override
    public Entretenimiento_DetailState getStateFromPreviousScreen() {
        return mediator.getPreviousEntretenimiento_DetailScreenState();
    }

    @Override
    public Entretenimiento_DetailState getStateFromNextScreen() {
        return mediator.getNextEntretenimiento_DetailScreenState();
    }
}
