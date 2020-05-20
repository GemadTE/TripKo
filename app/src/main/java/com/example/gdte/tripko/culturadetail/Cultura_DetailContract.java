package com.example.gdte.tripko.culturadetail;

import java.lang.ref.WeakReference;

public interface Cultura_DetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Cultura_DetailViewModel viewModel);

        void navigateToNextScreen();
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

        void passStateToNextScreen(Cultura_DetailState state);

        Cultura_DetailState getStateFromPreviousScreen();

        Cultura_DetailState getStateFromNextScreen();

        void passStateToPreviousScreen(Cultura_DetailState state);
    }
}
