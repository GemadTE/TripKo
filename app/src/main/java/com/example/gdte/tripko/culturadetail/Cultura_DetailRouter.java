package com.example.gdte.tripko.culturadetail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class Cultura_DetailRouter implements Cultura_DetailContract.Router {

    public static String TAG = Cultura_DetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public Cultura_DetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Cultura_DetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(Cultura_DetailState state) {
        mediator.setNextCultura_DetailScreenState(state);
    }

    @Override
    public void passStateToPreviousScreen(Cultura_DetailState state) {
        mediator.setPreviousCultura_DetailScreenState(state);
    }

    @Override
    public Cultura_DetailState getStateFromPreviousScreen() {
        return mediator.getPreviousCultura_DetailScreenState();
    }

    @Override
    public Cultura_DetailState getStateFromNextScreen() {
        return mediator.getNextCultura_DetailScreenState();
    }
}
