package com.example.gdte.tripko.culturadetaillist;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Cultura_Detail_ListPresenter implements Cultura_Detail_ListContract.Presenter {

    public static String TAG = Cultura_Detail_ListPresenter.class.getSimpleName();

    private WeakReference<Cultura_Detail_ListContract.View> view;
    private Cultura_Detail_ListState state;
    private Cultura_Detail_ListContract.Model model;
    private Cultura_Detail_ListContract.Router router;

    public Cultura_Detail_ListPresenter(Cultura_Detail_ListState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Cultura_Detail_ListState();
        }

        // use passed state if is necessary
        Cultura_Detail_ListState savedState = router.getStateFromPreviousScreen();
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
        Cultura_Detail_ListState savedState = router.getStateFromNextScreen();
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
    public void injectView(WeakReference<Cultura_Detail_ListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Cultura_Detail_ListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Cultura_Detail_ListContract.Router router) {
        this.router = router;
    }
}
