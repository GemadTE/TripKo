package com.example.gdte.tripko.menuprincipal;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.contactosdeinteres.Contactos_De_InteresActivity;
import com.example.gdte.tripko.conversormoneda.Conversor_MonedaActivity;
import com.example.gdte.tripko.entretenimiento.EntretenimientoActivity;
import com.example.gdte.tripko.idioma.IdiomaActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;
import com.example.gdte.tripko.regiones.Region_ListActivity;
import com.example.gdte.tripko.sitiosturisticos.Sitios_TuristicosActivity;
import com.example.gdte.tripko.sobrecorea.Sobre_CoreaActivity;
import com.example.gdte.tripko.transportecategory.Transporte_CategoryActivity;

public class Menu_PrincipalRouter implements Menu_PrincipalContract.Router {

    public static String TAG = Menu_PrincipalRouter.class.getSimpleName();

    private AppMediator mediator;

    public Menu_PrincipalRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

   /* @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Menu_PrincipalActivity.class);
        context.startActivity(intent);
    }*/

    @Override
    public void passDataToNextScreen(Menu_PrincipalState state) {
        mediator.setMenu_PrincipalState(state);
    }

    @Override
    public Menu_PrincipalState getDataFromPreviousScreen() {
        Menu_PrincipalState state = mediator.getMenu_PrincipalState();
        return state;
    }

    @Override
    public void navigateToSobreCoreaScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Sobre_CoreaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToIdiomaScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, IdiomaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToConversionDeMonedaScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Conversor_MonedaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToTransporteScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Transporte_CategoryActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToEntretenimientoScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, EntretenimientoActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToGastronomiaScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Region_ListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToSitiosTuristicosScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Sitios_TuristicosActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToContactosDeInteresScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Contactos_De_InteresActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToPreguntasFrecuentesScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Preguntas_FrecuentesActivity.class);
        context.startActivity(intent);
    }
}
