package com.example.gdte.tripko.contactosdeinteres;

import java.lang.ref.WeakReference;

public interface Contactos_De_InteresContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Contactos_De_InteresViewModel viewModel);
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

        void passStateToNextScreen(Contactos_De_InteresState state);

        Contactos_De_InteresState getStateFromPreviousScreen();

        Contactos_De_InteresState getStateFromNextScreen();

        void passStateToPreviousScreen(Contactos_De_InteresState state);
    }
}
