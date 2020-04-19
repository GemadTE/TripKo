package com.example.gdte.tripko.sitiosturisticos;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.data.Sitios_TuristicosItem;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.sitiosturisticosdetaillist.Sitios_Turisticos_DetailListActivity;

public class Sitios_TuristicosRouter implements Sitios_TuristicosContract.Router {

    public static String TAG = Sitios_TuristicosRouter.class.getSimpleName();

    private AppMediator mediator;

    public Sitios_TuristicosRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToSitioTuristicoDetailListScreen() {
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
    public void passDataToSitioTuristicoDetailListScreen(Sitios_TuristicosItem item) {
        mediator.setSitiosTuristicosItem(item);
    }


}
