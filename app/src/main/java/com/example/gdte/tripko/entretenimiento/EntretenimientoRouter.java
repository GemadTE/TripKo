package com.example.gdte.tripko.entretenimiento;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class EntretenimientoRouter implements EntretenimientoContract.Router {

    public static String TAG = EntretenimientoRouter.class.getSimpleName();

    private AppMediator mediator;

    public EntretenimientoRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, EntretenimientoActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(EntretenimientoState state) {
        mediator.setEntretenimientoState(state);
    }

    @Override
    public EntretenimientoState getDataFromPreviousScreen() {
        EntretenimientoState state = mediator.getEntretenimientoState();
        return state;
    }
}
