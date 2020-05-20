package com.example.gdte.tripko.expresionesdetaillist;

import java.lang.ref.WeakReference;

public interface Expresiones_Detail_ListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(Expresiones_Detail_ListViewModel viewModel);

        void navigateToNextScreen();
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

        void passDataToNextScreen(Expresiones_Detail_ListState state);

        Expresiones_Detail_ListState getDataFromPreviousScreen();
    }
}
