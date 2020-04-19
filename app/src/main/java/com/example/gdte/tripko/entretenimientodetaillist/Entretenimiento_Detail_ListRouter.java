package com.example.gdte.tripko.entretenimientodetaillist;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class Entretenimiento_Detail_ListRouter implements Entretenimiento_Detail_ListContract.Router {

    public static String TAG = Entretenimiento_Detail_ListRouter.class.getSimpleName();

    private AppMediator mediator;

    public Entretenimiento_Detail_ListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Entretenimiento_Detail_ListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(Entretenimiento_Detail_ListState state) {
        mediator.setNextEntretenimiento_Detail_ListScreenState(state);
    }

    @Override
    public void passStateToPreviousScreen(Entretenimiento_Detail_ListState state) {
        mediator.setPreviousEntretenimiento_Detail_ListScreenState(state);
    }

    @Override
    public Entretenimiento_Detail_ListState getStateFromPreviousScreen() {
        return mediator.getPreviousEntretenimiento_Detail_ListScreenState();
    }

    @Override
    public Entretenimiento_Detail_ListState getStateFromNextScreen() {
        return mediator.getNextEntretenimiento_Detail_ListScreenState();
    }
}
