package com.example.gdte.tripko.elegiridioma;

import java.lang.ref.WeakReference;

public class Pantalla_De_CargaPresenter implements Pantalla_De_CargaContract.Presenter {

    public static String TAG = Pantalla_De_CargaPresenter.class.getSimpleName();

    private WeakReference<Pantalla_De_CargaContract.View> view;
    private Pantalla_De_CargaState state;
    private Pantalla_De_CargaContract.Model model;
    private Pantalla_De_CargaContract.Router router;

    public Pantalla_De_CargaPresenter(Pantalla_De_CargaState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Pantalla_De_CargaState();
        }

        // use passed state if is necessary
        Pantalla_De_CargaState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<Pantalla_De_CargaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Pantalla_De_CargaContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Pantalla_De_CargaContract.Router router) {
        this.router = router;
    }
}
