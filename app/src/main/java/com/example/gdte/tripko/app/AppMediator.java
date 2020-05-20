package com.example.gdte.tripko.app;

import com.example.gdte.tripko.ciudadesprincipales.Ciudades_PrincipalesState;
import com.example.gdte.tripko.clima.ClimaState;
import com.example.gdte.tripko.contactosdeinteres.Contactos_De_InteresState;
import com.example.gdte.tripko.conversormoneda.Conversor_MonedaState;
import com.example.gdte.tripko.culturadetail.Cultura_DetailState;
import com.example.gdte.tripko.data.EntretenimientoItem;
import com.example.gdte.tripko.data.GastronomiaDetailItem;
import com.example.gdte.tripko.data.GastronomiaItem;
import com.example.gdte.tripko.data.RegionItem;
import com.example.gdte.tripko.data.Sitios_TuristicosDetailItem;
import com.example.gdte.tripko.data.Sitios_TuristicosItem;
import com.example.gdte.tripko.entretenimientodetail.Entretenimiento_DetailState;
import com.example.gdte.tripko.entretenimientodetaillist.Entretenimiento_Detail_ListState;
import com.example.gdte.tripko.expresionesdetaillist.Expresiones_Detail_ListState;
import com.example.gdte.tripko.gastronomialist.GastronomiaListState;
import com.example.gdte.tripko.gastronomiadetaillist.Gastronomia_Detail_ListState;
import com.example.gdte.tripko.cultura.CulturaState;
import com.example.gdte.tripko.elegiridioma.Elegir_IdiomaState;
import com.example.gdte.tripko.entretenimiento.EntretenimientoState;
import com.example.gdte.tripko.idioma.IdiomaState;
import com.example.gdte.tripko.idiomaalfabeto.Idioma_AlfabetoState;
import com.example.gdte.tripko.idiomacoreano.Idioma_CoreanoState;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalState;
import com.example.gdte.tripko.regiones.Region_ListState;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesState;
import com.example.gdte.tripko.sitiosturisticos.Sitios_TuristicosState;
import com.example.gdte.tripko.sitiosturisticosdetail.Sitios_Turisticos_DetailState;
import com.example.gdte.tripko.sobrecorea.Sobre_CoreaState;
import com.example.gdte.tripko.splash.SplashState;
import com.example.gdte.tripko.sitiosturisticosdetaillist.Sitios_Turisticos_DetailListState;
import com.example.gdte.tripko.transportecategory.Transporte_CategoryState;

public class AppMediator {

    private static AppMediator instance;
    private SplashState splashState;
    private Elegir_IdiomaState elegirIdiomaState;
    private Menu_PrincipalState menu_principalState;
    private Sobre_CoreaState sobreCoreaState;
    private CulturaState culturaState = new CulturaState();
    private Cultura_DetailState culturaDetailState;
    private Entretenimiento_Detail_ListState entretenimientoDetailListState;
    private Entretenimiento_DetailState entretenimientoDetailState;
    private ClimaState climaState;
    private Ciudades_PrincipalesState ciudadesPrincipalesState;
    private EntretenimientoState entretenimientoState;
    private Sitios_TuristicosState sitiosTuristicosState;
    private Sitios_Turisticos_DetailListState tiposDeSitiosTuristicosState;
    private Sitios_Turisticos_DetailState sitiosTuristicosDetailState;
    private Region_ListState regionListState;
    private GastronomiaListState comidaRestauranteListState;
    private Gastronomia_Detail_ListState comidaRestauranteDetailState;
    private Conversor_MonedaState conversorMonedaState;
    private Preguntas_FrecuentesState preguntasFrecuentesState;
    private Contactos_De_InteresState contactosDeInteresState;
    private Transporte_CategoryState transporteCategoryState;
    private IdiomaState idiomaState;
    private Idioma_CoreanoState idiomaCoreanoState;
    private Idioma_AlfabetoState idiomaAlfabetoState;
    private Expresiones_Detail_ListState expresionesDetailListState;

    private RegionItem regionItem;
    private GastronomiaItem gastronomiaItem;
    private GastronomiaDetailItem gastronomiaDetailItem;
    private Sitios_TuristicosItem sitiosTuristicosItem;
    private Sitios_TuristicosDetailItem sitiosTuristicosDetailItem;
    private EntretenimientoItem entretenimientoItem;


    private AppMediator() {
        splashState = new SplashState();
        elegirIdiomaState = new Elegir_IdiomaState();
        menu_principalState = new Menu_PrincipalState();
        sobreCoreaState = new Sobre_CoreaState();
        culturaDetailState = new Cultura_DetailState();
        entretenimientoDetailListState = new Entretenimiento_Detail_ListState();
        entretenimientoDetailState = new Entretenimiento_DetailState();
        climaState = new ClimaState();
        ciudadesPrincipalesState = new Ciudades_PrincipalesState();
        entretenimientoState = new EntretenimientoState();
        sitiosTuristicosState = new Sitios_TuristicosState();
        tiposDeSitiosTuristicosState = new Sitios_Turisticos_DetailListState();
        sitiosTuristicosDetailState = new Sitios_Turisticos_DetailState();
        regionListState = new Region_ListState();
        comidaRestauranteListState  = new GastronomiaListState();
        comidaRestauranteDetailState = new Gastronomia_Detail_ListState();
        conversorMonedaState = new Conversor_MonedaState();
        preguntasFrecuentesState = new Preguntas_FrecuentesState();
        contactosDeInteresState = new Contactos_De_InteresState();
        transporteCategoryState = new Transporte_CategoryState();
        idiomaCoreanoState = new Idioma_CoreanoState();
        idiomaAlfabetoState = new Idioma_AlfabetoState();
        expresionesDetailListState = new Expresiones_Detail_ListState();
    }

    public static AppMediator getInstance() {
        if (instance == null) {
            instance = new AppMediator();
        }
        return instance;
    }

    public static void resetInstance(){
        instance = null;
    }

    public SplashState getSplashState() {
        return splashState;
    }

    public void setSplashState(SplashState splashState) {
        this.splashState = splashState;
    }

    public Elegir_IdiomaState getElegirIdiomaState() {
        return elegirIdiomaState;
    }

    public void setElegirIdiomaState(Elegir_IdiomaState elegirIdiomaState) {
        this.elegirIdiomaState = elegirIdiomaState;
    }

    public Menu_PrincipalState getMenu_PrincipalState() {
        return menu_principalState;
    }

    public void setMenu_PrincipalState(Menu_PrincipalState menu_principalState) {
        this.menu_principalState = menu_principalState;
    }

    public Sobre_CoreaState getSobre_CoreaState() {
        return sobreCoreaState;
    }

    public void setSobre_CoreaState(Sobre_CoreaState sobreCoreaState) {
        this.sobreCoreaState = sobreCoreaState;
    }

    public CulturaState getCulturaState() {
        return culturaState;
    }

    public void setCulturaState(CulturaState culturaState) {
        this.culturaState = culturaState;
    }

    public ClimaState getClimaState() {
        return climaState;
    }

    public void setClimaState(ClimaState climaState) {
        this.climaState = climaState;
    }

    public Ciudades_PrincipalesState getCiudadesPrincipalesState() {
        return ciudadesPrincipalesState;
    }

    public void setCiudadesPrincipalesState(Ciudades_PrincipalesState ciudadesPrincipalesSate) {
        this.ciudadesPrincipalesState = ciudadesPrincipalesSate;
    }

    public EntretenimientoState getEntretenimientoState() {
        return entretenimientoState;
    }

    public void setEntretenimientoState(EntretenimientoState entretenimientoState) {
        this.entretenimientoState = entretenimientoState;
    }

    public Sitios_TuristicosState getSitiosTuristicosState() {
        return sitiosTuristicosState;
    }

    public void setSitiosTuristicosState(Sitios_TuristicosState sitiosTuristicosState) {
        this.sitiosTuristicosState = sitiosTuristicosState;
    }

    public Sitios_Turisticos_DetailListState getTiposDeSitiosTuristicosState() {
        return tiposDeSitiosTuristicosState;
    }

    public void setTiposDeSitiosTuristicosState(Sitios_Turisticos_DetailListState tiposDeSitiosTuristicosState) {
        this.tiposDeSitiosTuristicosState = tiposDeSitiosTuristicosState;
    }

    public Region_ListState getRegionListState() {
        return regionListState;
    }

    public void setRegionListState(Region_ListState regionState) {
        regionListState = regionState;
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

    public Conversor_MonedaState getConversorMonedaState() {
        return conversorMonedaState;
    }

    public void setConversorMonedaState(Conversor_MonedaState conversor_monedaState) {
        conversorMonedaState = conversor_monedaState;
    }

    public Preguntas_FrecuentesState getPreguntasFrecuentesState() {
        return preguntasFrecuentesState;
    }

    public void setPreguntasFrecuentesState(Preguntas_FrecuentesState preguntas_frecuentesState) {
        preguntasFrecuentesState = preguntasFrecuentesState;
    }

    public Contactos_De_InteresState getContactosDeInteresState() {
        return contactosDeInteresState;
    }

    public void setContactosDeInteresState(Contactos_De_InteresState contactosDeInteresState) {
        this.contactosDeInteresState = contactosDeInteresState;
    }

    public void setTransporteCategoryState(Transporte_CategoryState transporteCategoryState) {
        this.transporteCategoryState = transporteCategoryState;
    }

    public Transporte_CategoryState getTransporteCategoryState() {
        return transporteCategoryState;
    }


    public Cultura_DetailState getCulturaDetailState() {
        return culturaDetailState;
    }

    public void setCulturaDetailState(Cultura_DetailState culturaDetailState) {
        this.culturaDetailState = culturaDetailState;
    }

    public Entretenimiento_Detail_ListState getEntretenimientoDetailListState() {
        return entretenimientoDetailListState;
    }

    public void setEntretenimientoDetailListState(Entretenimiento_Detail_ListState entretenimientoDetailListState) {
        this.entretenimientoDetailListState = entretenimientoDetailListState;
    }

    public Entretenimiento_DetailState getEntretenimientoDetailState() {
        return entretenimientoDetailState;
    }

    public void setEntretenimientoDetailState(Entretenimiento_DetailState entretenimientoDetailState) {
        this.entretenimientoDetailState = entretenimientoDetailState;
    }

    public RegionItem getRegionItem() {
        RegionItem item = regionItem;
        return item;
    }

    public void setRegionItem(RegionItem regionItem) {
        this.regionItem = regionItem;
    }


    public GastronomiaItem getGastronomiaItem() {
        return gastronomiaItem;
    }

    public void setGastronomiaItem(GastronomiaItem gastronomiaItem) {
        this.gastronomiaItem = gastronomiaItem;
    }

    public GastronomiaDetailItem getGastronomiaDetailItem() {
        return gastronomiaDetailItem;
    }

    public void setGastronomiaDetailItem(GastronomiaDetailItem gastronomiaDetailItem) {
        this.gastronomiaDetailItem = gastronomiaDetailItem;
    }

    public Sitios_TuristicosItem getSitiosTuristicosItem() {
        return sitiosTuristicosItem;
    }

    public void setSitiosTuristicosItem(Sitios_TuristicosItem sitiosTuristicosItem) {
        this.sitiosTuristicosItem = sitiosTuristicosItem;
    }

    public Sitios_TuristicosDetailItem getSitiosTuristicosDetailItem() {
        return sitiosTuristicosDetailItem;
    }

    public void setSitiosTuristicosDetailItem(Sitios_TuristicosDetailItem sitiosTuristicosDetailItem) {
        this.sitiosTuristicosDetailItem = sitiosTuristicosDetailItem;
    }

    public Sitios_Turisticos_DetailState getSitiosTuristicosDetailState() {
        return sitiosTuristicosDetailState;
    }

    public void setSitiosTuristicosDetailState(Sitios_Turisticos_DetailState sitiosTuristicosDetailState) {
        this.sitiosTuristicosDetailState = sitiosTuristicosDetailState;
    }

    public EntretenimientoItem getEntretenimientoItem() {
        return entretenimientoItem;
    }

    public void setEntretenimientoItem(EntretenimientoItem entretenimientoItem) {
        this.entretenimientoItem = entretenimientoItem;
    }

    public IdiomaState getIdiomaState() {
        return idiomaState;
    }

    public void setIdiomaState(IdiomaState idiomaState) {
        this.idiomaState = idiomaState;
    }

    public void setIdiomaCoreanoState(Idioma_CoreanoState idiomaCoreanoState) {
        this.idiomaCoreanoState = idiomaCoreanoState;
    }

    public Idioma_CoreanoState getIdiomaCoreanoState() {
        return idiomaCoreanoState;
    }

    public void setIdiomaAlfabetoState(Idioma_AlfabetoState idiomaAlfabetoState) {
        this.idiomaAlfabetoState = idiomaAlfabetoState;
    }

    public Idioma_AlfabetoState getIdiomaAlfabetoState() {
        return idiomaAlfabetoState;
    }

    public void setExpresionesDetailListState(Expresiones_Detail_ListState expresionesDetailListState) {
        this.expresionesDetailListState = expresionesDetailListState;
    }

    public Expresiones_Detail_ListState getExpresionesDetailListState() {
        return expresionesDetailListState;
    }
}
