package com.example.gdte.tripko.sitiosturisticosdetaillist;

import java.lang.ref.WeakReference;

public class Sitios_Turisticos_DetailListPresenter implements Sitios_Turisticos_DetailListContract.Presenter {

    public static String TAG = Sitios_Turisticos_DetailListPresenter.class.getSimpleName();

    private WeakReference<Sitios_Turisticos_DetailListContract.View> view;
    private Sitios_Turisticos_DetailList_DetailListState state;
    private Sitios_Turisticos_DetailListContract.Model model;
    private Sitios_Turisticos_DetailListContract.Router router;

    public Sitios_Turisticos_DetailListPresenter(Sitios_Turisticos_DetailList_DetailListState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Sitios_Turisticos_DetailList_DetailListState();
        }

        // use passed state if is necessary
        Sitios_Turisticos_DetailList_DetailListState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<Sitios_Turisticos_DetailListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Sitios_Turisticos_DetailListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Sitios_Turisticos_DetailListContract.Router router) {
        this.router = router;
    }
}
