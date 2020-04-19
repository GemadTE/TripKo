package com.example.gdte.tripko.sobrecorea;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Sobre_CoreaPresenter implements Sobre_CoreaContract.Presenter {

    public static String TAG = Sobre_CoreaPresenter.class.getSimpleName();

    private WeakReference<Sobre_CoreaContract.View> view;
    private Sobre_CoreaState state;
    private Sobre_CoreaContract.Model model;
    private Sobre_CoreaContract.Router router;

    public Sobre_CoreaPresenter(Sobre_CoreaState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Sobre_CoreaState();
        }

        // use passed state if is necessary
        Sobre_CoreaState savedState = router.getDataFromPreviousScreen();
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
    public void goHomeButtonClicked() {
        router.navigateToHomeScreen();
    }

    @Override
    public void goPreguntasFrecuentesButtonClicked() {
        router.navigateToPreguntasFrecuentesScreen();
    }


    @Override
    public void goClimaButtonClicked() {
        router.navigateToClimaScreen();
    }

    @Override
    public void goCiudadesPrincipalesButtonClicked() {
        router.navigateToCiudadesPrincipalesScreen();
    }

    @Override
    public void goCulturaButtonClicked() {
        router.navigateToCulturaScreen();
    }

    @Override
    public void injectView(WeakReference<Sobre_CoreaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Sobre_CoreaContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Sobre_CoreaContract.Router router) {
        this.router = router;
    }
}
