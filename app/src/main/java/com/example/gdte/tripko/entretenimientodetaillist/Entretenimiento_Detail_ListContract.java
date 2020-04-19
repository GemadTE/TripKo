package com.example.gdte.tripko.entretenimientodetaillist;

import java.lang.ref.WeakReference;

public interface Entretenimiento_Detail_ListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Entretenimiento_Detail_ListViewModel viewModel);
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

        void passStateToNextScreen(Entretenimiento_Detail_ListState state);

        Entretenimiento_Detail_ListState getStateFromPreviousScreen();

        Entretenimiento_Detail_ListState getStateFromNextScreen();

        void passStateToPreviousScreen(Entretenimiento_Detail_ListState state);
    }
}
