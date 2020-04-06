package com.example.gdte.tripko.ciudadesprincipales;

import java.lang.ref.WeakReference;

public interface CiudadesPrincipalesContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(CiudadesPrincipalesViewModel viewModel);
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

        void passDataToNextScreen(CiudadesPrincipalesState state);

        CiudadesPrincipalesState getDataFromPreviousScreen();
    }
}
