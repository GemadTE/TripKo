package com.example.gdte.tripko.entretenimiento;

import android.util.Log;

import java.lang.ref.WeakReference;

public class EntretenimientoPresenter implements EntretenimientoContract.Presenter {

    public static String TAG = EntretenimientoPresenter.class.getSimpleName();

    private WeakReference<EntretenimientoContract.View> view;
    private EntretenimientoState state;
    private EntretenimientoContract.Model model;
    private EntretenimientoContract.Router router;

    public EntretenimientoPresenter(EntretenimientoState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new EntretenimientoState();
        }

        // use passed state if is necessary
        EntretenimientoState savedState = router.getDataFromPreviousScreen();
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
    public void goHomeButtonClicked() {
        router.navigateToHomeScreen();
    }


    @Override
    public void goPreguntasFrecuentesButtonClicked() {
        router.navigateToPreguntasFrecuentesScreen();
    }

    @Override
    public void injectView(WeakReference<EntretenimientoContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(EntretenimientoContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(EntretenimientoContract.Router router) {
        this.router = router;
    }
}
