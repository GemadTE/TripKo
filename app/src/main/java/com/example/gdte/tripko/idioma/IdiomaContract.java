package com.example.gdte.tripko.idioma;

import java.lang.ref.WeakReference;

public interface IdiomaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(IdiomaViewModel viewModel);

        void navigateToNextScreen();

        void navigateToIdiomaCoreanoScreen();

        void navigateToIdiomaAlfabetoScreen();

        void navigateToExpresionesDetailListScreen();

        void navigateToPreguntasFrecuentesScreen();

        void navigateToHomeScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void onIdiomaOptionClicked(int idiomaOption);

        void onPreguntasFrecuentesClicked();

        void goHomeButtonClicked();
    }

    interface Model {
        String fetchData();
    }

    interface Router {

        void passDataToNextScreen(IdiomaState state);

        IdiomaState getDataFromPreviousScreen();


    }
}
