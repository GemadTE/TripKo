package com.example.gdte.tripko.entretenimiento;

import java.lang.ref.WeakReference;

public interface EntretenimientoContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(EntretenimientoViewModel viewModel);
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
        void navigateToNextScreen();

        void passDataToNextScreen(EntretenimientoState state);

        void navigateToHomeScreen();

        void navigateToPreguntasFrecuentesScreen();

        EntretenimientoState getDataFromPreviousScreen();
    }
}
