package com.example.gdte.tripko.gastronomiadetaillist;

import java.lang.ref.WeakReference;

public interface Gastronomia_Detail_ListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Gastronomia_Detail_ListViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResume();

        void onStart();

        void goHomeButtonClicked();

        void goPreguntasFrecuentesButtonClicked();

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

        void navigateToPreguntasFrecuentesScreen();

        void passStateToNextScreen(Gastronomia_Detail_ListState state);

        Gastronomia_Detail_ListState getStateFromPreviousScreen();

        Gastronomia_Detail_ListState getStateFromNextScreen();

        void passStateToPreviousScreen(Gastronomia_Detail_ListState state);
    }
}
