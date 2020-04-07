package com.example.gdte.tripko.conversormoneda;

import java.lang.ref.WeakReference;

public interface Conversor_MonedaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Conversor_MonedaViewModel viewModel);
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

        void passStateToNextScreen(Conversor_MonedaState state);

        Conversor_MonedaState getStateFromPreviousScreen();

        Conversor_MonedaState getStateFromNextScreen();

        void passStateToPreviousScreen(Conversor_MonedaState state);
    }
}
