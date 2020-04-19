package com.example.gdte.tripko.sitiosturisticosdetaillist;

import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class Sitios_Turisticos_DetailListRouter implements Sitios_Turisticos_DetailListContract.Router {

    public static String TAG = Sitios_Turisticos_DetailListRouter.class.getSimpleName();

    private AppMediator mediator;

    public Sitios_Turisticos_DetailListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Sitios_Turisticos_DetailListActivity.class);
        context.startActivity(intent);
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
    public void passDataToNextScreen(Sitios_Turisticos_DetailListState state) {
        mediator.setTiposDeSitiosTuristicosState(state);
    }

    @Override
    public Sitios_Turisticos_DetailListState getDataFromPreviousScreen() {
        Sitios_Turisticos_DetailListState state = mediator.getTiposDeSitiosTuristicosState();
        return state;
    }
}
