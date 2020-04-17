package com.example.gdte.tripko.transportecategory;

import java.lang.ref.WeakReference;

public interface Transporte_CategoryContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Transporte_CategoryViewModel viewModel);
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

        void passStateToNextScreen(Transporte_CategoryState state);

        Transporte_CategoryState getStateFromPreviousScreen();

        Transporte_CategoryState getStateFromNextScreen();

        void passStateToPreviousScreen(Transporte_CategoryState state);
    }
}
