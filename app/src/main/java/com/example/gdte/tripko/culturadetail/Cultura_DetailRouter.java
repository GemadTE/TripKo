package com.example.gdte.tripko.culturadetail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Cultura_DetailRouter implements Cultura_DetailContract.Router {

    public static String TAG = Cultura_DetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public Cultura_DetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void passStateToNextScreen(Cultura_DetailState state) {
        mediator.setCulturaDetailState(state);
    }

    @Override
    public void passStateToPreviousScreen(Cultura_DetailState state) {
        mediator.setCulturaDetailState(state);
    }

    @Override
    public Cultura_DetailState getStateFromPreviousScreen() {
        return mediator.getCulturaDetailState();
    }

    @Override
    public Cultura_DetailState getStateFromNextScreen() {
        return mediator.getCulturaDetailState();
    }
}
