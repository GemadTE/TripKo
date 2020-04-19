package com.example.gdte.tripko.idioma;

import android.util.Log;

import java.lang.ref.WeakReference;

public class IdiomaPresenter implements IdiomaContract.Presenter {

    public static String TAG = IdiomaPresenter.class.getSimpleName();

    private WeakReference<IdiomaContract.View> view;
    private IdiomaState state;
    private IdiomaContract.Model model;
    private IdiomaContract.Router router;

    public IdiomaPresenter(IdiomaState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new IdiomaState();
        }

        // use passed state if is necessary
        IdiomaState savedState = router.getDataFromPreviousScreen();
        if (savedState != null) {

            // update view and model state
            state.data = savedState.data;

            // update the view
            view.get().displayData(state);

            return;
        }

        // call the model
        String data = model.fetchData();

        // set view state
        state.data = data;

        // update the view
        view.get().displayData(state);

    }

    @Override
    public void onIdiomaOptionClicked(int idiomaOption) {
        switch (idiomaOption){
            case 0:
                router.navigateToIdiomaCoreanoScreen();
                break;
            case 1:
                router.navigateToIdiomaAlfabetoScreen();
                break;
            case 2:
                router.navigateToExpresionesDetailListScreen();
                break;
            default:
                break;
        }
    }

    @Override
    public void onPreguntasFrecuentesClicked() {
        router.navigateToPreguntasFrecuentesScreen();
    }

    @Override
    public void goHomeButtonClicked() {
        router.navigateToHomeScreen();
    }

    @Override
    public void injectView(WeakReference<IdiomaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(IdiomaContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(IdiomaContract.Router router) {
        this.router = router;
    }
}
