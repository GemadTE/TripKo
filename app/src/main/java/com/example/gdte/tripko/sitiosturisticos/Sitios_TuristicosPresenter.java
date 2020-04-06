package com.example.gdte.tripko.sitiosturisticos;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Sitios_TuristicosPresenter implements Sitios_TuristicosContract.Presenter {

    public static String TAG = Sitios_TuristicosPresenter.class.getSimpleName();

    private WeakReference<Sitios_TuristicosContract.View> view;
    private Sitios_TuristicosState state;
    private Sitios_TuristicosContract.Model model;
    private Sitios_TuristicosContract.Router router;

    public Sitios_TuristicosPresenter(Sitios_TuristicosState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Sitios_TuristicosState();
        }

        // use passed state if is necessary
        Sitios_TuristicosState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<Sitios_TuristicosContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Sitios_TuristicosContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Sitios_TuristicosContract.Router router) {
        this.router = router;
    }
}
