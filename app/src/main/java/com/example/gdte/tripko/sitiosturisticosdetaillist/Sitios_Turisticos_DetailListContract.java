package com.example.gdte.tripko.sitiosturisticosdetaillist;

import com.example.gdte.tripko.data.RepositoryContract;
import com.example.gdte.tripko.data.Sitios_TuristicosDetailItem;
import com.example.gdte.tripko.data.Sitios_TuristicosItem;

import java.lang.ref.WeakReference;

public interface Sitios_Turisticos_DetailListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayProductListData(Sitios_Turisticos_DetailListViewModel viewModel);
    }

    interface Presenter {
        void fetchSitiosTuristicosDetailListData();

        void selectSitioTuristicoDetailListData(Sitios_TuristicosDetailItem item);

        void goHomeButtonClicked();

        void goPreguntasFrecuentesButtonClicked();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

    }

    interface Model {

        void fetchSitiosTuristicosListData(
                Sitios_TuristicosItem sitios_turisticosItem, RepositoryContract.GetSitioTuristicoDetailListCallback callback);
    }

    interface Router {
        void navigateToSitioTuristicoDetailScreen();

        void navigateToHomeScreen();

        void navigateToPreguntasFrecuentesScreen();

        void passDataToSitioTuristicoDetailScreen(Sitios_TuristicosDetailItem item);

        Sitios_TuristicosItem getDataFromSitiosTuristicosListScreen();
    }
}
