package com.example.gdte.tripko.app;

import android.app.Application;

import com.example.gdte.tripko.ciudadesprincipales.Ciudades_PrincipalesState;
import com.example.gdte.tripko.clima.ClimaState;
import com.example.gdte.tripko.gastronomialist.GastronomiaListState;
import com.example.gdte.tripko.gastronomiadetaillist.Gastronomia_Detail_ListState;
import com.example.gdte.tripko.cultura.CulturaState;
import com.example.gdte.tripko.elegiridioma.Elegir_IdiomaState;
import com.example.gdte.tripko.entretenimiento.EntretenimientoState;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalState;
import com.example.gdte.tripko.gastronomiaregiones.Gastronomia_Gastronomia_RegionesState;
import com.example.gdte.tripko.sitiosturisticos.Sitios_TuristicosState;
import com.example.gdte.tripko.sobrecorea.Sobre_CoreaState;
import com.example.gdte.tripko.splash.SplashState;
import com.example.gdte.tripko.tiposdesitiosturisticos.Tipos_De_Sitios_TuristicosState;

public class AppMediator extends Application {

    private SplashState splashState;
    private Elegir_IdiomaState elegirIdiomaState;
    private Menu_PrincipalState menu_principalState;
    private Sobre_CoreaState sobreCoreaState;
    private CulturaState culturaState;
    private ClimaState climaState;
    private Ciudades_PrincipalesState ciudadesPrincipalesSate;
    private EntretenimientoState entretenimientoState;
    private Sitios_TuristicosState sitiosTuristicosState;
    private Tipos_De_Sitios_TuristicosState tiposDeSitiosTuristicosState;
    private Gastronomia_Gastronomia_RegionesState gastronomiaRegionesState;
    private GastronomiaListState comidaRestauranteListState;
    private Gastronomia_Detail_ListState comidaRestauranteDetailState;

    public SplashState getSplashState() { return splashState; }
    public void setSplashState(SplashState splashState) { this.splashState = splashState; }

    public Elegir_IdiomaState getElegirIdiomaState() { return  elegirIdiomaState; }
    public void setElegirIdiomaState(Elegir_IdiomaState elegirIdiomaState) { this.elegirIdiomaState = elegirIdiomaState; }

    public Menu_PrincipalState getMenu_PrincipalState() { return menu_principalState; }
    public void setMenu_PrincipalState(Menu_PrincipalState menu_principalState) { this.menu_principalState = menu_principalState; }

    public Sobre_CoreaState getSobre_CoreaState() { return sobreCoreaState; }
    public void setSobre_CoreaState(Sobre_CoreaState sobreCoreaState) { this.sobreCoreaState=sobreCoreaState; }

    public CulturaState getCulturaState() { return culturaState; }
    public void setCulturaState(CulturaState culturaState) { this.culturaState=culturaState; }

    public ClimaState getClimaState() { return climaState; }
    public void setClimaState (ClimaState climaState) { this.climaState=climaState;}

    public Ciudades_PrincipalesState getCiudadesPrincipalesState(){ return ciudadesPrincipalesSate;}
    public void setCiudadesPrincipalesState (Ciudades_PrincipalesState ciudadesPrincipalesSate)
    {this.ciudadesPrincipalesSate=ciudadesPrincipalesSate;}

    public EntretenimientoState getEntretenimientoState() {return entretenimientoState;}
    public void setEntretenimientoState (EntretenimientoState entretenimientoState)
    {this.entretenimientoState=entretenimientoState;}

    public Sitios_TuristicosState getSitiosTuristicosState(){return sitiosTuristicosState;}
    public void setSitiosTuristicosState (Sitios_TuristicosState sitiosTuristicosState){
        this.sitiosTuristicosState=sitiosTuristicosState;
    }

    public Tipos_De_Sitios_TuristicosState getTiposDeSitiosTuristicosState(){return tiposDeSitiosTuristicosState;}
    public void setTiposDeSitiosTuristicosState (Tipos_De_Sitios_TuristicosState tiposDeSitiosTuristicosState){
        this.tiposDeSitiosTuristicosState=tiposDeSitiosTuristicosState;
    }

    public Gastronomia_Gastronomia_RegionesState getGastronomiaRegionesState() {
        return gastronomiaRegionesState;
    }

    public void setGastronomiaRegionesState(Gastronomia_Gastronomia_RegionesState regionState) {
        gastronomiaRegionesState = regionState;
    }

    public GastronomiaListState getComidaRestauranteListState() {
        return comidaRestauranteListState;
    }

    public void setComidaRestauranteListState(GastronomiaListState comidaRestauranteState) {
        comidaRestauranteListState = comidaRestauranteState;
    }

    public Gastronomia_Detail_ListState getComidarestaurantedetailState() {
        return comidaRestauranteDetailState;
    }

    public void setComidarestaurantedetailState(Gastronomia_Detail_ListState gastronomiaDetailListState) {
        comidaRestauranteDetailState = gastronomiaDetailListState;
    }
}
