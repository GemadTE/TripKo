package com.example.gdte.tripko.regiones;

import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.data.RegionItem;
import com.example.gdte.tripko.gastronomialist.GastronomiaListActivity;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class Region_ListRouter implements Region_ListContract.Router {

    public static String TAG = Region_ListRouter.class.getSimpleName();

    private AppMediator mediator;

    public Region_ListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToGastronomiaListScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, GastronomiaListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
    public void passDataToGastronomiaListScreen(RegionItem item) {
        mediator.setRegionItem(item);
    }


    @Override
    public Region_ListState getStateFromNextScreen() {
        return mediator.getRegionListState();
    }
}
