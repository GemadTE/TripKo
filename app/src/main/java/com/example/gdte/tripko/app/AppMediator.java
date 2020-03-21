package com.example.gdte.tripko.app;

import android.app.Application;

import com.example.gdte.tripko.pantalladecarga.Pantalla_De_CargaState;
import com.example.gdte.tripko.sobrecorea.Sobre_CoreaState;

public class AppMediator extends Application {

    private Sobre_CoreaState sobreCoreaState;
    private Pantalla_De_CargaState pantalla_de_cargaState;

    public Sobre_CoreaState getSobre_CoreaState() {
        return sobreCoreaState;
    }

    public void setSobre_CoreaState(Sobre_CoreaState sobreCoreaState) { this.sobreCoreaState=sobreCoreaState; }


    public Pantalla_De_CargaState getPantalla_De_CargaState() { return  pantalla_de_cargaState; }

    public void setPantalla_De_CargaState(Pantalla_De_CargaState pantalla_de_cargaState) { this.pantalla_de_cargaState=pantalla_de_cargaState; }
}
