package com.example.gdte.tripko.splash;

import java.lang.ref.WeakReference;

public interface SplashContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void navigateToChooseLanguageScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void goChooseLanguage();
    }

    interface Model {
    }

    interface Router {

    }
}
