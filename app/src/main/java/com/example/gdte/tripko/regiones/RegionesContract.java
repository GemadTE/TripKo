package com.example.gdte.tripko.regiones;

import java.lang.ref.WeakReference;

public interface RegionesContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(RegionesViewModel viewModel);
    }

    interface Presenter {
        void goMenuButtonClicked();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResume();

        void onStart();

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

        void passStateToNextScreen(RegionesState state);

        RegionesState getStateFromNextScreen();

    }
}
