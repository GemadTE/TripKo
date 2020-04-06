package com.example.gdte.tripko.cultura;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class CulturaRouter implements CulturaContract.Router {

    public static String TAG = CulturaRouter.class.getSimpleName();

    private AppMediator mediator;

    public CulturaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, CulturaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(CulturaState state) {
        mediator.setCulturaState(state);
    }

    @Override
    public CulturaState getDataFromPreviousScreen() {
        CulturaState state = mediator.getCulturaState();
        return state;
    }
}
