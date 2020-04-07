package com.example.gdte.tripko.gastronomiaregiones;

import java.lang.ref.WeakReference;

public class Gastronomia_RegionesPresenter implements Gastronomia_RegionesContract.Presenter {

    public static String TAG = Gastronomia_RegionesPresenter.class.getSimpleName();

    private WeakReference<Gastronomia_RegionesContract.View> view;
    private Gastronomia_Gastronomia_RegionesState state;
    private Gastronomia_RegionesContract.Model model;
    private Gastronomia_RegionesContract.Router router;

    public Gastronomia_RegionesPresenter(Gastronomia_Gastronomia_RegionesState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Gastronomia_Gastronomia_RegionesState();
        }

        // use passed state if is necessary

    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

        // use passed state if is necessary
        Gastronomia_Gastronomia_RegionesState savedState = router.getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }

    @Override
    public void goMenuButtonClicked() {
        router.navigateToNextScreen();
    }

    @Override
    public void injectView(WeakReference<Gastronomia_RegionesContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Gastronomia_RegionesContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Gastronomia_RegionesContract.Router router) {
        this.router = router;
    }
}
