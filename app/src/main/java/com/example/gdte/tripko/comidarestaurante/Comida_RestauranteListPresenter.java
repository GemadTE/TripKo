package com.example.gdte.tripko.comidarestaurante;

import java.lang.ref.WeakReference;

public class Comida_RestauranteListPresenter implements Comida_RestauranteListContract.Presenter {

    public static String TAG = Comida_RestauranteListPresenter.class.getSimpleName();

    private WeakReference<Comida_RestauranteListContract.View> view;
    private Comida_RestauranteListState state;
    private Comida_RestauranteListContract.Model model;
    private Comida_RestauranteListContract.Router router;

    public Comida_RestauranteListPresenter(Comida_RestauranteListState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Comida_RestauranteListState();
        }

        // use passed state if is necessary
        Comida_RestauranteListState savedState = router.getStateFromPreviousScreen();
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
        Comida_RestauranteListState savedState = router.getStateFromNextScreen();
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
    public void injectView(WeakReference<Comida_RestauranteListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Comida_RestauranteListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Comida_RestauranteListContract.Router router) {
        this.router = router;
    }
}
