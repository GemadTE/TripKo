package com.example.gdte.tripko.entretenimientodetail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class Entretenimiento_DetailRouter implements Entretenimiento_DetailContract.Router {

    public static String TAG = Entretenimiento_DetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public Entretenimiento_DetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Entretenimiento_DetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(Entretenimiento_DetailState state) {
        mediator.setEntretenimientoDetailState(state);
    }

    @Override
    public void passStateToPreviousScreen(Entretenimiento_DetailState state) {
        mediator.setEntretenimientoDetailState(state);
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
    public Entretenimiento_DetailState getStateFromPreviousScreen() {
        return mediator.getEntretenimientoDetailState();
    }

    @Override
    public Entretenimiento_DetailState getStateFromNextScreen() {
        return mediator.getEntretenimientoDetailState();
    }
}
