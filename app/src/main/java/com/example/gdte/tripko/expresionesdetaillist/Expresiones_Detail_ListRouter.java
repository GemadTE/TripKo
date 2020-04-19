package com.example.gdte.tripko.expresionesdetaillist;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Expresiones_Detail_ListRouter implements Expresiones_Detail_ListContract.Router {

    public static String TAG = Expresiones_Detail_ListRouter.class.getSimpleName();

    private AppMediator mediator;

    public Expresiones_Detail_ListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Expresiones_Detail_ListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(Expresiones_Detail_ListState state) {
        mediator.setExpresionesDetailListState(state);
    }

    @Override
    public Expresiones_Detail_ListState getDataFromPreviousScreen() {
        Expresiones_Detail_ListState state = mediator.getExpresionesDetailListState();
        return state;
    }

}
