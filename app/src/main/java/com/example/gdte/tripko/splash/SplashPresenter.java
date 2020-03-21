package com.example.gdte.tripko.splash;

import java.lang.ref.WeakReference;

public class SplashPresenter implements SplashContract.Presenter {

    public static String TAG = SplashPresenter.class.getSimpleName();

    private WeakReference<SplashContract.View> view;
    private SplashState state;
    private SplashContract.Model model;
    private SplashContract.Router router;

    public SplashPresenter(SplashState state) {
        this.state = state;
    }

    @Override
    public void injectView(WeakReference<SplashContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(SplashContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(SplashContract.Router router) {
        this.router = router;
    }

    @Override
    public void goChooseLanguage(){
        router.navigateToChooseLanguageScreen();
    }
}
