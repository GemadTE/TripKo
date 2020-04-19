package com.example.gdte.tripko.cultura;

import android.util.Log;

import java.lang.ref.WeakReference;

public class CulturaPresenter implements CulturaContract.Presenter {

    public static String TAG = CulturaPresenter.class.getSimpleName();

    private WeakReference<CulturaContract.View> view;
    private CulturaState state;
    private CulturaContract.Model model;
    private CulturaContract.Router router;

    public CulturaPresenter(CulturaState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new CulturaState();
        }

        // use passed state if is necessary
        CulturaState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<CulturaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CulturaContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(CulturaContract.Router router) {
        this.router = router;
    }
}
