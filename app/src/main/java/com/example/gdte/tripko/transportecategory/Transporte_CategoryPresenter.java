package com.example.gdte.tripko.transportecategory;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Transporte_CategoryPresenter implements Transporte_CategoryContract.Presenter {

    public static String TAG = Transporte_CategoryPresenter.class.getSimpleName();

    private WeakReference<Transporte_CategoryContract.View> view;
    private Transporte_CategoryState state;
    private Transporte_CategoryContract.Model model;
    private Transporte_CategoryContract.Router router;

    public Transporte_CategoryPresenter(Transporte_CategoryState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Transporte_CategoryState();
        }

        // use passed state if is necessary
        Transporte_CategoryState savedState = router.getStateFromPreviousScreen();
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
        Transporte_CategoryState savedState = router.getStateFromNextScreen();
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
    public void injectView(WeakReference<Transporte_CategoryContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Transporte_CategoryContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Transporte_CategoryContract.Router router) {
        this.router = router;
    }
}
