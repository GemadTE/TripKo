package com.example.gdte.tripko.transportecategory;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Transporte_CategoryRouter implements Transporte_CategoryContract.Router {

    public static String TAG = Transporte_CategoryRouter.class.getSimpleName();

    private AppMediator mediator;

    public Transporte_CategoryRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Transporte_CategoryActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(Transporte_CategoryState state) {
        mediator.setTransporteCategoryState(state);
    }

    @Override
    public void passStateToPreviousScreen(Transporte_CategoryState state) {
        mediator.setTransporteCategoryState(state);
    }

    @Override
    public Transporte_CategoryState getStateFromPreviousScreen() {
        return mediator.getTransporteCategoryState();
    }

    @Override
    public Transporte_CategoryState getStateFromNextScreen() {
        return mediator.getTransporteCategoryState();
    }
}
