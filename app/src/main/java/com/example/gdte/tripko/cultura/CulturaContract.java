package com.example.gdte.tripko.cultura;

import java.lang.ref.WeakReference;

public interface CulturaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(CulturaViewModel viewModel);

        void navigateToNextScreen();

        void navigateToHomeScreen();

        void navigateToPreguntasFrecuentesScreen();
    }

    interface Presenter {
        void goHomeButtonClicked();

        void goPreguntasFrecuentesButtonClicked();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();
    }

    interface Model {
        String fetchData();
    }

    interface Router {


        void passDataToNextScreen(CulturaState state);

        CulturaState getDataFromPreviousScreen();
    }
}
