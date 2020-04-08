package com.example.gdte.tripko.gastronomialist;

import java.lang.ref.WeakReference;

public interface GastronomiaListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(GastronomiaListViewModel viewModel);
    }

    interface Presenter {
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

        void passStateToNextScreen(GastronomiaListState state);

        GastronomiaListState getStateFromPreviousScreen();

        GastronomiaListState getStateFromNextScreen();

        void passStateToPreviousScreen(GastronomiaListState state);
    }
}
