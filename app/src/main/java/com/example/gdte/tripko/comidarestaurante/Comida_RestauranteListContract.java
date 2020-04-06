package com.example.gdte.tripko.comidarestaurante;

import java.lang.ref.WeakReference;

public interface Comida_RestauranteListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Comida_RestauranteListViewModel viewModel);
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

        void passStateToNextScreen(Comida_RestauranteListState state);

        Comida_RestauranteListState getStateFromPreviousScreen();

        Comida_RestauranteListState getStateFromNextScreen();

        void passStateToPreviousScreen(Comida_RestauranteListState state);
    }
}
