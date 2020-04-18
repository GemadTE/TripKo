package com.example.gdte.tripko.idioma;

import java.lang.ref.WeakReference;

public interface IdiomaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(IdiomaViewModel viewModel);
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

        void passDataToNextScreen(IdiomaState state);

        IdiomaState getDataFromPreviousScreen();
    }
}