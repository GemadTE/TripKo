package com.example.gdte.tripko.sobrecorea;

import java.lang.ref.WeakReference;

public interface Sobre_CoreaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(Sobre_CoreaViewModel viewModel);
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

        void passDataToNextScreen(Sobre_CoreaState state);

        Sobre_CoreaState getDataFromPreviousScreen();
    }
}
