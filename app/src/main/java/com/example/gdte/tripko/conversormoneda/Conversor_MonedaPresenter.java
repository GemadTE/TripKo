package com.example.gdte.tripko.conversormoneda;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Conversor_MonedaPresenter implements Conversor_MonedaContract.Presenter {

    public static String TAG = Conversor_MonedaPresenter.class.getSimpleName();

    private WeakReference<Conversor_MonedaContract.View> view;
    private Conversor_MonedaState state;
    private Conversor_MonedaContract.Model model;
    private Conversor_MonedaContract.Router router;

    public Conversor_MonedaPresenter(Conversor_MonedaState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Conversor_MonedaState();
        }

        // use passed state if is necessary
        Conversor_MonedaState savedState = router.getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);
        }
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
        Conversor_MonedaState savedState = router.getStateFromNextScreen();
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
    public void goHomeButtonClicked() {
        router.navigateToHomeScreen();
    }

    @Override
    public void injectView(WeakReference<Conversor_MonedaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Conversor_MonedaContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Conversor_MonedaContract.Router router) {
        this.router = router;
    }
}
