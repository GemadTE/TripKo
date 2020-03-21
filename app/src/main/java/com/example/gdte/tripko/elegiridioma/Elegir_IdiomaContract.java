package com.example.gdte.tripko.elegiridioma;

import java.lang.ref.WeakReference;

public interface Elegir_IdiomaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(Elegir_IdiomaViewModel viewModel);
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

        void passDataToNextScreen(Elegir_IdiomaState state);

        Elegir_IdiomaState getDataFromPreviousScreen();
    }
}
