package com.example.gdte.tripko.sitiosturisticosdetail;

import java.lang.ref.WeakReference;

public interface Sitios_Turisticos_DetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Sitios_Turisticos_DetailViewModel viewModel);
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

        void passStateToNextScreen(Sitios_Turisticos_DetailState state);

        Sitios_Turisticos_DetailState getStateFromPreviousScreen();

        Sitios_Turisticos_DetailState getStateFromNextScreen();

        void passStateToPreviousScreen(Sitios_Turisticos_DetailState state);
    }
}
