package com.example.gdte.tripko.pantalladecarga;

import java.lang.ref.WeakReference;

public interface Pantalla_De_CargaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(Pantalla_De_CargaViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(Pantalla_De_CargaState state);

        Pantalla_De_CargaState getDataFromPreviousScreen();
    }
}
