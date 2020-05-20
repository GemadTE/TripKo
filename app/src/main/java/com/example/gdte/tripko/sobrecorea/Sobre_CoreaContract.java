package com.example.gdte.tripko.sobrecorea;

import java.lang.ref.WeakReference;

public interface Sobre_CoreaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(Sobre_CoreaViewModel viewModel);

        void navigateToNextScreen();

        void navigateToHomeScreen();

        void navigateToPreguntasFrecuentesScreen();

        void navigateToClimaScreen();

        void navigateToCiudadesPrincipalesScreen();

        void navigateToCulturaScreen();
    }

    interface Presenter {
        void goHomeButtonClicked();

        void goPreguntasFrecuentesButtonClicked();

        void goClimaButtonClicked();

        void goCiudadesPrincipalesButtonClicked();

        void goCulturaButtonClicked();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();
    }

    interface Model {
        String fetchData();
    }

    interface Router {

        void passDataToNextScreen(Sobre_CoreaState state);

        Sobre_CoreaState getDataFromPreviousScreen();
    }
}
