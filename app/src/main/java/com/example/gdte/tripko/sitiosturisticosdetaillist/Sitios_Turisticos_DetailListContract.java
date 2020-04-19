package com.example.gdte.tripko.sitiosturisticosdetaillist;

import java.lang.ref.WeakReference;

public interface Sitios_Turisticos_DetailListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(Sitios_Turisticos_DetailListViewModel viewModel);
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

        void passDataToNextScreen(Sitios_Turisticos_DetailList_DetailListState state);

        Sitios_Turisticos_DetailList_DetailListState getDataFromPreviousScreen();
    }
}
