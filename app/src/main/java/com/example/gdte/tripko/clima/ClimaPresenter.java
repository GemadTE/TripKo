package com.example.gdte.tripko.clima;

import android.util.Log;

import java.lang.ref.WeakReference;

public class ClimaPresenter implements ClimaContract.Presenter {

    public static String TAG = ClimaPresenter.class.getSimpleName();

    private WeakReference<ClimaContract.View> view;
    private ClimaState state;
    private ClimaContract.Model model;
    private ClimaContract.Router router;

    public ClimaPresenter(ClimaState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new ClimaState();
        }

        // use passed state if is necessary
        ClimaState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<ClimaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ClimaContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ClimaContract.Router router) {
        this.router = router;
    }
}
