package com.example.gdte.tripko.app;

import android.app.Application;

import com.example.gdte.tripko.sobrecorea.Sobre_CoreaState;

public class AppMediator extends Application {
    private Sobre_CoreaState sobreCoreaState;
    public Sobre_CoreaState getSobre_CoreaState() {
        return sobreCoreaState;
    }
    public void setSobre_CoreaState(Sobre_CoreaState sobreCoreaState) {
        sobreCoreaState=sobreCoreaState;
    }


}
