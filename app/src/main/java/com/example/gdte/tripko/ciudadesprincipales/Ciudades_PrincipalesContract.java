package com.example.gdte.tripko.ciudadesprincipales;

import java.lang.ref.WeakReference;

public interface Ciudades_PrincipalesContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(Ciudades_PrincipalesViewModel viewModel);
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

        void passDataToNextScreen(Ciudades_PrincipalesState state);

        Ciudades_PrincipalesState getDataFromPreviousScreen();
    }
}
