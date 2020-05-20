package com.example.gdte.tripko.regiones;

import com.example.gdte.tripko.data.RegionItem;
import com.example.gdte.tripko.data.RepositoryContract;

import java.lang.ref.WeakReference;

public interface Region_ListContract {

    interface View {

        void displayRegionListData(final Region_ListViewModel viewModel);

        void injectPresenter(Presenter presenter);

        void navigateToGastronomiaListScreen();

        void navigateToHomeScreen();

        void navigateToPreguntasFrecuentesScreen();
    }

    interface Presenter {

        void selectRegionListData(RegionItem item);

        void fetchRegionListData();

        void goHomeButtonClicked();

        void goPreguntasFrecuentesButtonClicked();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

    }

    interface Model {

        void fetchRegionListData(
                RepositoryContract.GetRegionListCallback callback);
    }

    interface Router {

        void passDataToGastronomiaListScreen(RegionItem item);

        Region_ListState getStateFromNextScreen();

    }
}
