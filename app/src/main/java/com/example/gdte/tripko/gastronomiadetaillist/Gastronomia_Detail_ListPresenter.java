package com.example.gdte.tripko.gastronomiadetaillist;

import java.lang.ref.WeakReference;

public class Gastronomia_Detail_ListPresenter implements Gastronomia_Detail_ListContract.Presenter {

    public static String TAG = Gastronomia_Detail_ListPresenter.class.getSimpleName();

    private WeakReference<Gastronomia_Detail_ListContract.View> view;
    private Gastronomia_Detail_ListState state;
    private Gastronomia_Detail_ListContract.Model model;
    private Gastronomia_Detail_ListContract.Router router;

    public Gastronomia_Detail_ListPresenter(Gastronomia_Detail_ListState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Gastronomia_Detail_ListState();
        }

        // use passed state if is necessary
        Gastronomia_Detail_ListState savedState = router.getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);
        }
    }

    @Override
    public void goHomeButtonClicked() {
        router.navigateToHomeScreen();
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
        Gastronomia_Detail_ListState savedState = router.getStateFromNextScreen();
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
    public void injectView(WeakReference<Gastronomia_Detail_ListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Gastronomia_Detail_ListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Gastronomia_Detail_ListContract.Router router) {
        this.router = router;
    }
}
