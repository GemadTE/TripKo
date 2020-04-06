package com.example.gdte.tripko.cultura;

import java.lang.ref.WeakReference;

public interface CulturaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(CulturaViewModel viewModel);
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

        void passDataToNextScreen(CulturaState state);

        CulturaState getDataFromPreviousScreen();
    }
}
