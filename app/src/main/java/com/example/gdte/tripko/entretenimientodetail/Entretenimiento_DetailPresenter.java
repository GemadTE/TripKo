package com.example.gdte.tripko.entretenimientodetail;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Entretenimiento_DetailPresenter implements Entretenimiento_DetailContract.Presenter {

    public static String TAG = Entretenimiento_DetailPresenter.class.getSimpleName();

    private WeakReference<Entretenimiento_DetailContract.View> view;
    private Entretenimiento_DetailState state;
    private Entretenimiento_DetailContract.Model model;
    private Entretenimiento_DetailContract.Router router;

    public Entretenimiento_DetailPresenter(Entretenimiento_DetailState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Entretenimiento_DetailState();
        }

        // use passed state if is necessary
        Entretenimiento_DetailState savedState = router.getStateFromPreviousScreen();
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
        Entretenimiento_DetailState savedState = router.getStateFromNextScreen();
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
    public void goHomeButtonClicked() {
        router.navigateToHomeScreen();
    }


    @Override
    public void goPreguntasFrecuentesButtonClicked() {
        router.navigateToPreguntasFrecuentesScreen();
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
    public void injectView(WeakReference<Entretenimiento_DetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Entretenimiento_DetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Entretenimiento_DetailContract.Router router) {
        this.router = router;
    }
}
