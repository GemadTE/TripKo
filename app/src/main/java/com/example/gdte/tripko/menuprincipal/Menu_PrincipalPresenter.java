package com.example.gdte.tripko.menuprincipal;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Menu_PrincipalPresenter implements Menu_PrincipalContract.Presenter {

    public static String TAG = Menu_PrincipalPresenter.class.getSimpleName();

    private WeakReference<Menu_PrincipalContract.View> view;
    private Menu_PrincipalState state;
    private Menu_PrincipalContract.Model model;
    private Menu_PrincipalContract.Router router;

    public Menu_PrincipalPresenter(Menu_PrincipalState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Menu_PrincipalState();
        }

        // use passed state if is necessary
        Menu_PrincipalState savedState = router.getDataFromPreviousScreen();
        if (savedState != null) {

            // update view and model state
            state.data = savedState.data;

            // update the view
            view.get().displayData(state);

            return;
        }

        // call the model
        String data = model.fetchData();

        // set view state
        state.data = data;

        // update the view
        view.get().displayData(state);

    }

    @Override
    public void onMenuOptionClicked(int option) {
        switch (option){
            case 0:
                view.get().navigateToSobreCoreaScreen();
                break;
            case 1:
                view.get().navigateToIdiomaScreen();
                break;
            case 2:
                view.get().navigateToConversionDeMonedaScreen();
                break;
            case 3:
                view.get().navigateToTransporteScreen();
                break;
            case 4:
                view.get().navigateToEntretenimientoScreen();
                break;
            case 5:
                view.get().navigateToGastronomiaScreen();
                break;
            case 6:
                view.get().navigateToSitiosTuristicosScreen();
                break;
            case 7:
                view.get().navigateToContactosDeInteresScreen();
                break;
            default:
                break;
        }
    }

    @Override
    public void onPreguntasFrecuentesClicked() {
        view.get().navigateToPreguntasFrecuentesScreen();
    }

    @Override
    public void injectView(WeakReference<Menu_PrincipalContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Menu_PrincipalContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Menu_PrincipalContract.Router router) {
        this.router = router;
    }
}
