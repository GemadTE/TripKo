package com.example.gdte.tripko.ciudadesprincipales;

import android.util.Log;

import java.lang.ref.WeakReference;

public class CiudadesPrincipalesPresenter implements CiudadesPrincipalesContract.Presenter {

    public static String TAG = CiudadesPrincipalesPresenter.class.getSimpleName();

    private WeakReference<CiudadesPrincipalesContract.View> view;
    private CiudadesPrincipalesState state;
    private CiudadesPrincipalesContract.Model model;
    private CiudadesPrincipalesContract.Router router;

    public CiudadesPrincipalesPresenter(CiudadesPrincipalesState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new CiudadesPrincipalesState();
        }

        // use passed state if is necessary
        CiudadesPrincipalesState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<CiudadesPrincipalesContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CiudadesPrincipalesContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(CiudadesPrincipalesContract.Router router) {
        this.router = router;
    }
}
