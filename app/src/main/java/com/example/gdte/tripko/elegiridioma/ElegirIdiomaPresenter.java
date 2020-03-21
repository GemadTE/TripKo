package com.example.gdte.tripko.elegiridioma;

import android.util.Log;

import java.lang.ref.WeakReference;

public class ElegirIdiomaPresenter implements ElegirIdiomaContract.Presenter {

    public static String TAG = ElegirIdiomaPresenter.class.getSimpleName();

    private WeakReference<ElegirIdiomaContract.View> view;
    private ElegirIdiomaState state;
    private ElegirIdiomaContract.Model model;
    private ElegirIdiomaContract.Router router;

    public ElegirIdiomaPresenter(ElegirIdiomaState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new ElegirIdiomaState();
        }

        // use passed state if is necessary
        ElegirIdiomaState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<ElegirIdiomaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ElegirIdiomaContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ElegirIdiomaContract.Router router) {
        this.router = router;
    }
}
