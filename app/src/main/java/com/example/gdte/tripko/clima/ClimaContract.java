package com.example.gdte.tripko.clima;

import java.lang.ref.WeakReference;

public interface ClimaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ClimaViewModel viewModel);
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

        void passDataToNextScreen(ClimaState state);

        ClimaState getDataFromPreviousScreen();
    }
}
