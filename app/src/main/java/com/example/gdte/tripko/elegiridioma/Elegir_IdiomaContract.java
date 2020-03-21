package com.example.gdte.tripko.elegiridioma;

import java.lang.ref.WeakReference;

public interface Elegir_IdiomaContract {

    interface View {
        void injectPresenter(Presenter presenter);

    }

    interface Presenter {
        void goMenuButtonClicked();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

    }

    interface Model {
    }

    interface Router {
        void navigateToMenuScreen();

        void passDataToMenuScreen(Elegir_IdiomaState state);

    }
}
