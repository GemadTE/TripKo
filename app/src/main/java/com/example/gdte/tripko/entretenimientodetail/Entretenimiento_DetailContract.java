package com.example.gdte.tripko.entretenimientodetail;

import java.lang.ref.WeakReference;

public interface Entretenimiento_DetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Entretenimiento_DetailViewModel viewModel);
    }

    interface Presenter {
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

        void passStateToNextScreen(Entretenimiento_DetailState state);

        Entretenimiento_DetailState getStateFromPreviousScreen();

        Entretenimiento_DetailState getStateFromNextScreen();

        void passStateToPreviousScreen(Entretenimiento_DetailState state);
    }
}
