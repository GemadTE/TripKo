package com.example.gdte.tripko.comidarestaurantedetail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Comida_restaurante_detailRouter implements Comida_restaurante_detailContract.Router {

    public static String TAG = Comida_restaurante_detailRouter.class.getSimpleName();

    private AppMediator mediator;

    public Comida_restaurante_detailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Comida_restaurante_detailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(Comida_restaurante_detailState state) {
        mediator.setComidarestaurantedetailState(state);
    }

    @Override
    public void passStateToPreviousScreen(Comida_restaurante_detailState state) {
        mediator.setComidarestaurantedetailState(state);
    }

    @Override
    public Comida_restaurante_detailState getStateFromPreviousScreen() {
        return mediator.getComidarestaurantedetailState();
    }

    @Override
    public Comida_restaurante_detailState getStateFromNextScreen() {
        return mediator.getComidarestaurantedetailState();
    }
}
