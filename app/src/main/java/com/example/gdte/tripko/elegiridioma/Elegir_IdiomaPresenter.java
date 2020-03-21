package com.example.gdte.tripko.elegiridioma;

import java.lang.ref.WeakReference;

public class Elegir_IdiomaPresenter implements Elegir_IdiomaContract.Presenter {

    public static String TAG = Elegir_IdiomaPresenter.class.getSimpleName();

    private WeakReference<Elegir_IdiomaContract.View> view;
    private Elegir_IdiomaState state;
    private Elegir_IdiomaContract.Model model;
    private Elegir_IdiomaContract.Router router;

    public Elegir_IdiomaPresenter(Elegir_IdiomaState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Elegir_IdiomaState();
        }

        // use passed state if is necessary
        Elegir_IdiomaState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<Elegir_IdiomaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Elegir_IdiomaContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Elegir_IdiomaContract.Router router) {
        this.router = router;
    }
}
