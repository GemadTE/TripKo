package com.example.gdte.tripko.idiomacoreano;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Idioma_CoreanoPresenter implements Idioma_CoreanoContract.Presenter {

    public static String TAG = Idioma_CoreanoPresenter.class.getSimpleName();

    private WeakReference<Idioma_CoreanoContract.View> view;
    private Idioma_CoreanoState state;
    private Idioma_CoreanoContract.Model model;
    private Idioma_CoreanoContract.Router router;

    public Idioma_CoreanoPresenter(Idioma_CoreanoState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Idioma_CoreanoState();
        }

        // use passed state if is necessary
        Idioma_CoreanoState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<Idioma_CoreanoContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Idioma_CoreanoContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Idioma_CoreanoContract.Router router) {
        this.router = router;
    }
}
