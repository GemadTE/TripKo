package com.example.gdte.tripko.elegiridioma;

import java.lang.ref.WeakReference;

public class Elegir_IdiomaPresenter implements Elegir_IdiomaContract.Presenter {

    public static String TAG = Elegir_IdiomaPresenter.class.getSimpleName();

    private WeakReference<Elegir_IdiomaContract.View> view;
    private Elegir_IdiomaState state;
    private Elegir_IdiomaContract.Model model;
    private Elegir_IdiomaContract.Router router;

    public Elegir_IdiomaPresenter(Elegir_IdiomaState state) {
        this.state = state;
    }

    @Override
    public void goMenuButtonClicked() {
        router.navigateToMenuScreen();
    }

    @Override
    public void injectView(WeakReference<Elegir_IdiomaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Elegir_IdiomaContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Elegir_IdiomaContract.Router router) {
        this.router = router;
    }
}
