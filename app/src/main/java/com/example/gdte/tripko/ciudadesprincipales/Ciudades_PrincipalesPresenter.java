package com.example.gdte.tripko.ciudadesprincipales;

import android.util.Log;

import java.lang.ref.WeakReference;

public class Ciudades_PrincipalesPresenter implements Ciudades_PrincipalesContract.Presenter {

    public static String TAG = Ciudades_PrincipalesPresenter.class.getSimpleName();

    private WeakReference<Ciudades_PrincipalesContract.View> view;
    private Ciudades_PrincipalesState state;
    private Ciudades_PrincipalesContract.Model model;
    private Ciudades_PrincipalesContract.Router router;

    public Ciudades_PrincipalesPresenter(Ciudades_PrincipalesState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Ciudades_PrincipalesState();
        }


            // update the view
            view.get().displayData(state);

            return;
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
    public void injectView(WeakReference<Ciudades_PrincipalesContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Ciudades_PrincipalesContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Ciudades_PrincipalesContract.Router router) {
        this.router = router;
    }
}
