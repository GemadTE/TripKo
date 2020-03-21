package com.example.gdte.tripko.splash;

import java.lang.ref.WeakReference;

public interface SplashContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(SplashViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void goChooseLanguage();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToChooseLanguageScreen();

        void passDataToNextScreen(SplashState state);

        SplashState getDataFromPreviousScreen();
    }
}
