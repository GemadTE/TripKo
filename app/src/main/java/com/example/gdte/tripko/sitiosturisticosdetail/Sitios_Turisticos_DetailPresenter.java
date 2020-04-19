package com.example.gdte.tripko.sitiosturisticosdetail;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Sitios_Turisticos_DetailPresenter implements Sitios_Turisticos_DetailContract.Presenter {

    public static String TAG = Sitios_Turisticos_DetailPresenter.class.getSimpleName();

    private WeakReference<Sitios_Turisticos_DetailContract.View> view;
    private Sitios_Turisticos_DetailState state;
    private Sitios_Turisticos_DetailContract.Model model;
    private Sitios_Turisticos_DetailContract.Router router;

    public Sitios_Turisticos_DetailPresenter(Sitios_Turisticos_DetailState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Sitios_Turisticos_DetailState();
        }

        // use passed state if is necessary
        Sitios_Turisticos_DetailState savedState = router.getStateFromPreviousScreen();
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
        Sitios_Turisticos_DetailState savedState = router.getStateFromNextScreen();
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
    public void injectView(WeakReference<Sitios_Turisticos_DetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Sitios_Turisticos_DetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Sitios_Turisticos_DetailContract.Router router) {
        this.router = router;
    }
}
