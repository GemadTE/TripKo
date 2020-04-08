package com.example.gdte.tripko.gastronomialist;

import java.lang.ref.WeakReference;

public class GastronomiaListPresenter implements GastronomiaListContract.Presenter {

    public static String TAG = GastronomiaListPresenter.class.getSimpleName();

    private WeakReference<GastronomiaListContract.View> view;
    private GastronomiaListState state;
    private GastronomiaListContract.Model model;
    private GastronomiaListContract.Router router;

    public GastronomiaListPresenter(GastronomiaListState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new GastronomiaListState();
        }

        // use passed state if is necessary
        GastronomiaListState savedState = router.getStateFromPreviousScreen();
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
        GastronomiaListState savedState = router.getStateFromNextScreen();
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
    public void injectView(WeakReference<GastronomiaListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(GastronomiaListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(GastronomiaListContract.Router router) {
        this.router = router;
    }
}
