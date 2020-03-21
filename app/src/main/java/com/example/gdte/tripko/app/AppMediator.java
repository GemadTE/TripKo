package com.example.gdte.tripko.app;

import android.app.Application;

import com.example.gdte.tripko.elegiridioma.Elegir_IdiomaState;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalState;
import com.example.gdte.tripko.sobrecorea.Sobre_CoreaState;
import com.example.gdte.tripko.splash.SplashState;

public class AppMediator extends Application {

    private SplashState splashState;
    private Elegir_IdiomaState elegirIdiomaState;
    private Menu_PrincipalState menu_principalState;
    private Sobre_CoreaState sobreCoreaState;


    public SplashState getSplashState() { return splashState; }
    public void setSplashState(SplashState splashState) { this.splashState = splashState; }

    public Elegir_IdiomaState getElegirIdiomaState() { return  elegirIdiomaState; }
    public void setElegirIdiomaState(Elegir_IdiomaState elegirIdiomaState) { this.elegirIdiomaState = elegirIdiomaState; }

    public Menu_PrincipalState getMenu_PrincipalState() { return menu_principalState; }
    public void setMenu_PrincipalState(Menu_PrincipalState menu_principalState) { this.menu_principalState = menu_principalState; }

    public Sobre_CoreaState getSobre_CoreaState() { return sobreCoreaState; }
    public void setSobre_CoreaState(Sobre_CoreaState sobreCoreaState) { this.sobreCoreaState=sobreCoreaState; }



}
