package com.example.gdte.tripko.culturadetaillist;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Cultura_Detail_ListRouter implements Cultura_Detail_ListContract.Router {

    public static String TAG = Cultura_Detail_ListRouter.class.getSimpleName();

    private AppMediator mediator;

    public Cultura_Detail_ListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Cultura_Detail_ListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(Cultura_Detail_ListState state) {
        mediator.setCulturaDetailListState(state);
    }

    @Override
    public void passStateToPreviousScreen(Cultura_Detail_ListState state) {
        mediator.setCulturaDetailListState(state);
    }

    @Override
    public Cultura_Detail_ListState getStateFromPreviousScreen() {
        return mediator.getCulturaDetailListState();
    }

    @Override
    public Cultura_Detail_ListState getStateFromNextScreen() {
        return mediator.getCulturaDetailListState();
    }
}
