package com.example.gdte.tripko.conversormoneda;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class Conversor_MonedaRouter implements Conversor_MonedaContract.Router {

    public static String TAG = Conversor_MonedaRouter.class.getSimpleName();

    private AppMediator mediator;

    public Conversor_MonedaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToHomeScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Menu_PrincipalActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void navigateToPreguntasFrecuentesScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Preguntas_FrecuentesActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(Conversor_MonedaState state) {
        mediator.setConversorMonedaState(state);
    }

    @Override
    public void passStateToPreviousScreen(Conversor_MonedaState state) {
        mediator.setConversorMonedaState(state);
    }

    @Override
    public Conversor_MonedaState getStateFromPreviousScreen() {
        return mediator.getConversorMonedaState();
    }

    @Override
    public Conversor_MonedaState getStateFromNextScreen() {
        return mediator.getConversorMonedaState();
    }
}
