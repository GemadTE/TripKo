package com.example.gdte.tripko.comidarestaurantedetail;

import java.lang.ref.WeakReference;

public interface Comida_restaurante_detailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Comida_restaurante_detailViewModel viewModel);
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

        void passStateToNextScreen(Comida_restaurante_detailState state);

        Comida_restaurante_detailState getStateFromPreviousScreen();

        Comida_restaurante_detailState getStateFromNextScreen();

        void passStateToPreviousScreen(Comida_restaurante_detailState state);
    }
}
