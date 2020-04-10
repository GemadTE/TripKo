package com.example.gdte.tripko.preguntasfrecuentes;

import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Preguntas_FrecuentesRouter implements Preguntas_FrecuentesContract.Router {

    public static String TAG = Preguntas_FrecuentesRouter.class.getSimpleName();

    private AppMediator mediator;

    public Preguntas_FrecuentesRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Preguntas_FrecuentesActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(Preguntas_FrecuentesState state) {
        mediator.setPreguntasFrecuentesState(state);
    }

    @Override
    public void passStateToPreviousScreen(Preguntas_FrecuentesState state) {
        mediator.setPreguntasFrecuentesState(state);
    }

    @Override
    public Preguntas_FrecuentesState getStateFromPreviousScreen() {
        return mediator.getPreguntasFrecuentesState();
    }

    @Override
    public Preguntas_FrecuentesState getStateFromNextScreen() {
        return mediator.getPreguntasFrecuentesState();
    }
}
