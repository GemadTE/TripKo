package com.example.gdte.tripko.preguntasfrecuentes;

import java.lang.ref.WeakReference;

public interface Preguntas_FrecuentesContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Preguntas_FrecuentesViewModel viewModel);
    }

    interface Presenter {
        void goHomeButtonClicked();

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

        void navigateToHomeScreen();

        void passStateToNextScreen(Preguntas_FrecuentesState state);

        Preguntas_FrecuentesState getStateFromPreviousScreen();

        Preguntas_FrecuentesState getStateFromNextScreen();

        void passStateToPreviousScreen(Preguntas_FrecuentesState state);
    }
}
