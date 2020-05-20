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
    public void passDataToGastronomiaListScreen(RegionItem item) {
        mediator.setRegionItem(item);
    }


    @Override
    public Region_ListState getStateFromNextScreen() {
        return mediator.getRegionListState();
    }
}
