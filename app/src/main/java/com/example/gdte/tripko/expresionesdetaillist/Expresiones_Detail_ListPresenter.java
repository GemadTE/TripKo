package com.example.gdte.tripko.expresionesdetaillist;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Expresiones_Detail_ListPresenter implements Expresiones_Detail_ListContract.Presenter {

    public static String TAG = Expresiones_Detail_ListPresenter.class.getSimpleName();

    private WeakReference<Expresiones_Detail_ListContract.View> view;
    private Expresiones_Detail_ListState state;
    private Expresiones_Detail_ListContract.Model model;
    private Expresiones_Detail_ListContract.Router router;

    public Expresiones_Detail_ListPresenter(Expresiones_Detail_ListState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Expresiones_Detail_ListState();
        }

        // use passed state if is necessary
        Expresiones_Detail_ListState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<Expresiones_Detail_ListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Expresiones_Detail_ListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Expresiones_Detail_ListContract.Router router) {
        this.router = router;
    }
}
