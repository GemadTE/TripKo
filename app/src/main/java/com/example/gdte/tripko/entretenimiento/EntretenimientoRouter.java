package com.example.gdte.tripko.entretenimiento;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.data.EntretenimientoItem;
import com.example.gdte.tripko.entretenimientodetaillist.Entretenimiento_Detail_ListActivity;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class EntretenimientoRouter implements EntretenimientoContract.Router {

    public static String TAG = EntretenimientoRouter.class.getSimpleName();

    private AppMediator mediator;

    public EntretenimientoRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void passDataToNextScreen(EntretenimientoState state) {
        mediator.setEntretenimientoState(state);
    }

    @Override
    public void passDataToEntretenimientoDetailListScreen(EntretenimientoItem item) {
        mediator.setEntretenimientoItem(item);
    }


    @Override
    public EntretenimientoState getDataFromPreviousScreen() {
        EntretenimientoState state = mediator.getEntretenimientoState();
        return state;
    }
}
