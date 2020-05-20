package com.example.gdte.tripko.sitiosturisticos;

import com.example.gdte.tripko.data.RepositoryContract;
import com.example.gdte.tripko.data.Sitios_TuristicosItem;

import java.lang.ref.WeakReference;

public interface Sitios_TuristicosContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displaySitioTuristicoListData(Sitios_TuristicosViewModel viewModel);

        void navigateToSitioTuristicoDetailListScreen();

        void navigateToHomeScreen();

        void navigateToPreguntasFrecuentesScreen();
    }

    interface Presenter {
        void fetchSitioTuristicoListData();

        void selectSitioTuristicoListData(Sitios_TuristicosItem item);

        void goHomeButtonClicked();

        void goPreguntasFrecuentesButtonClicked();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);
    }

    interface Model {

        void fetchSitioTuristicoListData(
                RepositoryContract.GetSitioTuristicoListCallback callback);
    }

    interface Router {

        void passDataToSitioTuristicoDetailListScreen(Sitios_TuristicosItem item);

    }
}
