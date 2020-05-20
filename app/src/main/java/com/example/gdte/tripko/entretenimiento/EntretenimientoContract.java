package com.example.gdte.tripko.entretenimiento;

import com.example.gdte.tripko.data.EntretenimientoItem;
import com.example.gdte.tripko.data.RepositoryContract;

import java.lang.ref.WeakReference;

public interface EntretenimientoContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayEntretenimientoListData(EntretenimientoViewModel viewModel);

        void navigateToHomeScreen();

        void navigateToPreguntasFrecuentesScreen();

        void navigateToEntretenimientoDetailListScreen();

    }

    interface Presenter {
        void fetchEntretenimientoListData();

        void selectEntretenimientoListData(EntretenimientoItem item);

        void goHomeButtonClicked();

        void goPreguntasFrecuentesButtonClicked();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

    }

    interface Model {

        void fetchEntretenimientoListData(
                RepositoryContract.GetEntretenimientoListCallback callback);
    }

    interface Router {

        void passDataToNextScreen(EntretenimientoState state);

        void passDataToEntretenimientoDetailListScreen(EntretenimientoItem item);

        EntretenimientoState getDataFromPreviousScreen();
    }
}
