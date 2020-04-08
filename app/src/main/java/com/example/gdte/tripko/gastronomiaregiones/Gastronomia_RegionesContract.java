package com.example.gdte.tripko.gastronomiaregiones;

import java.lang.ref.WeakReference;

public interface Gastronomia_RegionesContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Gastronomia_RegionesViewModel viewModel);
    }

    interface Presenter {
        void goMenuButtonClicked();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResume();

        void onStart();

        void goHomeButtonClicked();

        void onRestart();

        void onBackPressed();

        void onPause();

        void onDestroy();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

    interface Router {
        void navigateToNextScreen();

        void navigateToHomeScreen();

        void passStateToNextScreen(Gastronomia_RegionesState state);

        Gastronomia_RegionesState getStateFromNextScreen();

    }
}
