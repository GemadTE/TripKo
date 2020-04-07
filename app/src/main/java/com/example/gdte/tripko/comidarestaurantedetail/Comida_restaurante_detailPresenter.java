package com.example.gdte.tripko.comidarestaurantedetail;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Comida_restaurante_detailPresenter implements Comida_restaurante_detailContract.Presenter {

    public static String TAG = Comida_restaurante_detailPresenter.class.getSimpleName();

    private WeakReference<Comida_restaurante_detailContract.View> view;
    private Comida_restaurante_detailState state;
    private Comida_restaurante_detailContract.Model model;
    private Comida_restaurante_detailContract.Router router;

    public Comida_restaurante_detailPresenter(Comida_restaurante_detailState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Comida_restaurante_detailState();
        }

        // use passed state if is necessary
        Comida_restaurante_detailState savedState = router.getStateFromPreviousScreen();
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
        Comida_restaurante_detailState savedState = router.getStateFromNextScreen();
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
    public void injectView(WeakReference<Comida_restaurante_detailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Comida_restaurante_detailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Comida_restaurante_detailContract.Router router) {
        this.router = router;
    }
}
