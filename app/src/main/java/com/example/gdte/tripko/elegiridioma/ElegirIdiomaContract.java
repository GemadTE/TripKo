package com.example.gdte.tripko.elegiridioma;

import java.lang.ref.WeakReference;

public interface ElegirIdiomaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ElegirIdiomaViewModel viewModel);
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

        void passDataToNextScreen(ElegirIdiomaState state);

        ElegirIdiomaState getDataFromPreviousScreen();
    }
}
