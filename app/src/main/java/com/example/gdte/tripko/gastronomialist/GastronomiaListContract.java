package com.example.gdte.tripko.gastronomialist;

import com.example.gdte.tripko.data.GastronomiaItem;
import com.example.gdte.tripko.data.RegionItem;
import com.example.gdte.tripko.data.RepositoryContract;

import java.lang.ref.WeakReference;
import java.util.List;

public interface GastronomiaListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayProductListData(GastronomiaListViewModel viewModel);

        void navigateToGastronomiaDetailListScreen();

        void navigateToHomeScreen();

        void navigateToPreguntasFrecuentesScreen();
    }

    interface Presenter {
        void goPreguntasFrecuentesButtonClicked();

        void selectGastronomiaListData(GastronomiaItem item);

        void fetchProductListData();

        void goHomeButtonClicked();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);
    }

    interface Model {

        void fetchGastronomiaListData(
                RegionItem region, RepositoryContract.GetGastronomiaListCallback callback);
    }

    interface Router {

        void passDataToGastronomiaDetailListScreen(GastronomiaItem item);

        RegionItem getDataFromRegionListScreen();

        GastronomiaListState getStateFromPreviousScreen();

        GastronomiaListState getStateFromNextScreen();

    }
}
