package com.example.gdte.tripko.gastronomialist;

import com.example.gdte.tripko.data.GastronomiaItem;

import java.lang.ref.WeakReference;
import java.util.List;

public interface GastronomiaListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayProductListData(GastronomiaListViewModel viewModel);
    }

    interface Presenter {
        void selectGastronomiaListData(GastronomiaItem item);

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchProductListData();

        void onResume();

        void onStart();

        void goHomeButtonClicked();


        void onBackPressed();

        void onPause();

        void onDestroy();
    }

    interface Model {

        List<GastronomiaItem> fetchProductListData();
    }

    interface Router {
        void navigateToGastronomiaDetailListScreen();

        void navigateToHomeScreen();

        void passDataToGastronomiaDetailListScreen(GastronomiaItem item);

        void passStateToNextScreen(GastronomiaListState state);

        GastronomiaListState getStateFromPreviousScreen();

        GastronomiaListState getStateFromNextScreen();

        void passStateToPreviousScreen(GastronomiaListState state);
    }
}
