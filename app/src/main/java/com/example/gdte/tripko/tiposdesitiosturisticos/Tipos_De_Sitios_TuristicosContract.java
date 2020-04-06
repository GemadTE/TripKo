package com.example.gdte.tripko.tiposdesitiosturisticos;

import java.lang.ref.WeakReference;

public interface Tipos_De_Sitios_TuristicosContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(Tipos_De_Sitios_TuristicosViewModel viewModel);
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

        void passDataToNextScreen(Tipos_De_Sitios_TuristicosState state);

        Tipos_De_Sitios_TuristicosState getDataFromPreviousScreen();
    }
}
