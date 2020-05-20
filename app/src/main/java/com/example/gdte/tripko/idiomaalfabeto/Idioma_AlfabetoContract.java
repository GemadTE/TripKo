package com.example.gdte.tripko.idiomaalfabeto;

import java.lang.ref.WeakReference;

public interface Idioma_AlfabetoContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(Idioma_AlfabetoViewModel viewModel);

        void navigateToNextScreen();
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

        void passDataToNextScreen(Idioma_AlfabetoState state);

        Idioma_AlfabetoState getDataFromPreviousScreen();
    }
}
