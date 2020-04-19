package com.example.gdte.tripko.idiomacoreano;

import java.lang.ref.WeakReference;

public interface Idioma_CoreanoContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(Idioma_CoreanoViewModel viewModel);
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

        void passDataToNextScreen(Idioma_CoreanoState state);

        Idioma_CoreanoState getDataFromPreviousScreen();
    }
}
