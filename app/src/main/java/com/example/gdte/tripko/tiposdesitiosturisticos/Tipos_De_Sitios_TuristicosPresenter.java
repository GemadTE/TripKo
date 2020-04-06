package com.example.gdte.tripko.tiposdesitiosturisticos;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Tipos_De_Sitios_TuristicosPresenter implements Tipos_De_Sitios_TuristicosContract.Presenter {

    public static String TAG = Tipos_De_Sitios_TuristicosPresenter.class.getSimpleName();

    private WeakReference<Tipos_De_Sitios_TuristicosContract.View> view;
    private Tipos_De_Sitios_TuristicosState state;
    private Tipos_De_Sitios_TuristicosContract.Model model;
    private Tipos_De_Sitios_TuristicosContract.Router router;

    public Tipos_De_Sitios_TuristicosPresenter(Tipos_De_Sitios_TuristicosState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Tipos_De_Sitios_TuristicosState();
        }

        // use passed state if is necessary
        Tipos_De_Sitios_TuristicosState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<Tipos_De_Sitios_TuristicosContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Tipos_De_Sitios_TuristicosContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Tipos_De_Sitios_TuristicosContract.Router router) {
        this.router = router;
    }
}
