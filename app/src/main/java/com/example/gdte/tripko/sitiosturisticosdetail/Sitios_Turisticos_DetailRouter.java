package com.example.gdte.tripko.sitiosturisticosdetail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Sitios_Turisticos_DetailRouter implements Sitios_Turisticos_DetailContract.Router {

    public static String TAG = Sitios_Turisticos_DetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public Sitios_Turisticos_DetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Sitios_Turisticos_DetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(Sitios_Turisticos_DetailState state) {
        mediator.setSitiosTuristicosDetailState(state);
    }

    @Override
    public void passStateToPreviousScreen(Sitios_Turisticos_DetailState state) {
        mediator.setSitiosTuristicosDetailState(state);
    }

    @Override
    public Sitios_Turisticos_DetailState getStateFromPreviousScreen() {
        return mediator.getSitiosTuristicosDetailState();
    }

    @Override
    public Sitios_Turisticos_DetailState getStateFromNextScreen() {
        return mediator.getSitiosTuristicosDetailState();
    }
}
