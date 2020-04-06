package com.example.gdte.tripko.sitiosturisticos;

import java.lang.ref.WeakReference;

public interface Sitios_TuristicosContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(Sitios_TuristicosViewModel viewModel);
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

        void passDataToNextScreen(Sitios_TuristicosState state);

        Sitios_TuristicosState getDataFromPreviousScreen();
    }
}
