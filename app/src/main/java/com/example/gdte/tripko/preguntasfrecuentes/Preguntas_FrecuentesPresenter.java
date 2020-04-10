package com.example.gdte.tripko.preguntasfrecuentes;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Preguntas_FrecuentesPresenter implements Preguntas_FrecuentesContract.Presenter {

    public static String TAG = Preguntas_FrecuentesPresenter.class.getSimpleName();

    private WeakReference<Preguntas_FrecuentesContract.View> view;
    private Preguntas_FrecuentesState state;
    private Preguntas_FrecuentesContract.Model model;
    private Preguntas_FrecuentesContract.Router router;

    public Preguntas_FrecuentesPresenter(Preguntas_FrecuentesState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Preguntas_FrecuentesState();
        }

        // use passed state if is necessary
        Preguntas_FrecuentesState savedState = router.getStateFromPreviousScreen();
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
        Preguntas_FrecuentesState savedState = router.getStateFromNextScreen();
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
    public void injectView(WeakReference<Preguntas_FrecuentesContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Preguntas_FrecuentesContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Preguntas_FrecuentesContract.Router router) {
        this.router = router;
    }
}
