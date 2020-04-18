package com.example.gdte.tripko.menuprincipal;

import java.lang.ref.WeakReference;

public interface Menu_PrincipalContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(Menu_PrincipalViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void onMenuOptionClicked(int option);
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        // void navigateToNextScreen();

        void passDataToNextScreen(Menu_PrincipalState state);

        Menu_PrincipalState getDataFromPreviousScreen();

        void navigateToSobreCoreaScreen();

        void navigateToIdiomaScreen();

        void navigateToConversionDeMonedaScreen();

        void navigateToTransporteScreen();

        void navigateToEntretenimientoScreen();

        void navigateToGastronomiaScreen();

        void navigateToSitiosTuristicosScreen();

        void navigateToContactosDeInteresScreen();
    }
}
