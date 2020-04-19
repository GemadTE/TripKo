package com.example.gdte.tripko.idioma;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.expresionesdetaillist.Expresiones_Detail_ListActivity;
import com.example.gdte.tripko.idiomaalfabeto.Idioma_AlfabetoActivity;
import com.example.gdte.tripko.idiomacoreano.Idioma_CoreanoActivity;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class IdiomaRouter implements IdiomaContract.Router {

    public static String TAG = IdiomaRouter.class.getSimpleName();

    private AppMediator mediator;

    public IdiomaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, IdiomaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(IdiomaState state) {
        mediator.setIdiomaState(state);
    }

    @Override
    public IdiomaState getDataFromPreviousScreen() {
        IdiomaState state = mediator.getIdiomaState();
        return state;
    }

    @Override
    public void navigateToIdiomaCoreanoScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Idioma_CoreanoActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToIdiomaAlfabetoScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Idioma_AlfabetoActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToExpresionesDetailListScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Expresiones_Detail_ListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToPreguntasFrecuentesScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Preguntas_FrecuentesActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToHomeScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Menu_PrincipalActivity.class);
        context.startActivity(intent);
    }
}
