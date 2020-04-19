package com.example.gdte.tripko.entretenimiento;

import android.util.Log;

import com.example.gdte.tripko.data.EntretenimientoItem;
import com.example.gdte.tripko.data.RepositoryContract;

import java.lang.ref.WeakReference;
import java.util.List;

public class EntretenimientoPresenter implements EntretenimientoContract.Presenter {

    public static String TAG = EntretenimientoPresenter.class.getSimpleName();

    private WeakReference<EntretenimientoContract.View> view;
    private EntretenimientoState state;
    private EntretenimientoContract.Model model;
    private EntretenimientoContract.Router router;

    public EntretenimientoPresenter(EntretenimientoState state) {
        this.state = state;
    }

    @Override
    public void fetchEntretenimientoListData() {
        // Log.e(TAG, "fetchCategoryListData()");

        // call the model
        model.fetchEntretenimientoListData(new RepositoryContract.GetEntretenimientoListCallback() {

            @Override
            public void setEntretenimientoList(List<EntretenimientoItem> entretenimientoItems) {
                state.entretenimientos = entretenimientoItems;

                view.get().displayEntretenimientoListData(state);
            }
        });

    }

    @Override
    public void selectEntretenimientoListData(EntretenimientoItem item) {
        router.passDataToEntretenimientoDetailListScreen(item);
        router.navigateToEntretenimientoDetailListScreen();
    }

    @Override
    public void goHomeButtonClicked() {
        router.navigateToHomeScreen();
    }


    @Override
    public void goPreguntasFrecuentesButtonClicked() {
        router.navigateToPreguntasFrecuentesScreen();
    }

    @Override
    public void injectView(WeakReference<EntretenimientoContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(EntretenimientoContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(EntretenimientoContract.Router router) {
        this.router = router;
    }
}
