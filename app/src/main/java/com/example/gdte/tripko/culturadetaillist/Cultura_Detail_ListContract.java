package com.example.gdte.tripko.culturadetaillist;

import java.lang.ref.WeakReference;

public interface Cultura_Detail_ListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Cultura_Detail_ListViewModel viewModel);
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

        void passStateToNextScreen(Cultura_Detail_ListState state);

        Cultura_Detail_ListState getStateFromPreviousScreen();

        Cultura_Detail_ListState getStateFromNextScreen();

        void passStateToPreviousScreen(Cultura_Detail_ListState state);
    }
}
