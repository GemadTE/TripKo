package com.example.gdte.tripko.idiomaalfabeto;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Idioma_AlfabetoPresenter implements Idioma_AlfabetoContract.Presenter {

    public static String TAG = Idioma_AlfabetoPresenter.class.getSimpleName();

    private WeakReference<Idioma_AlfabetoContract.View> view;
    private Idioma_AlfabetoState state;
    private Idioma_AlfabetoContract.Model model;
    private Idioma_AlfabetoContract.Router router;

    public Idioma_AlfabetoPresenter(Idioma_AlfabetoState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Idioma_AlfabetoState();
        }

        // use passed state if is necessary
        Idioma_AlfabetoState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<Idioma_AlfabetoContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Idioma_AlfabetoContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Idioma_AlfabetoContract.Router router) {
        this.router = router;
    }
}
