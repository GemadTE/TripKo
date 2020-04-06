package com.example.gdte.tripko.regiones;

import android.util.Log;

import java.lang.ref.WeakReference;

public class RegionesPresenter implements RegionesContract.Presenter {

    public static String TAG = RegionesPresenter.class.getSimpleName();

    private WeakReference<RegionesContract.View> view;
    private RegionesState state;
    private RegionesContract.Model model;
    private RegionesContract.Router router;

    public RegionesPresenter(RegionesState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new RegionesState();
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
        RegionesState savedState = router.getStateFromNextScreen();
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
    public void injectView(WeakReference<RegionesContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(RegionesContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(RegionesContract.Router router) {
        this.router = router;
    }
}
