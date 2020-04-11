package com.example.gdte.tripko.contactosdeinteres;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Contactos_De_InteresPresenter implements Contactos_De_InteresContract.Presenter {

    public static String TAG = Contactos_De_InteresPresenter.class.getSimpleName();

    private WeakReference<Contactos_De_InteresContract.View> view;
    private Contactos_De_InteresState state;
    private Contactos_De_InteresContract.Model model;
    private Contactos_De_InteresContract.Router router;

    public Contactos_De_InteresPresenter(Contactos_De_InteresState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Contactos_De_InteresState();
        }

        // use passed state if is necessary
        Contactos_De_InteresState savedState = router.getStateFromPreviousScreen();
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
        Contactos_De_InteresState savedState = router.getStateFromNextScreen();
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
    public void injectView(WeakReference<Contactos_De_InteresContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Contactos_De_InteresContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Contactos_De_InteresContract.Router router) {
        this.router = router;
    }
}
