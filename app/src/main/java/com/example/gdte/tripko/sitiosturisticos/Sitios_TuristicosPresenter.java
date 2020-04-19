package com.example.gdte.tripko.sitiosturisticos;

import android.util.Log;

import com.example.gdte.tripko.data.RepositoryContract;
import com.example.gdte.tripko.data.Sitios_TuristicosItem;

import java.lang.ref.WeakReference;
import java.util.List;

public class Sitios_TuristicosPresenter implements Sitios_TuristicosContract.Presenter {

    public static String TAG = Sitios_TuristicosPresenter.class.getSimpleName();

    private WeakReference<Sitios_TuristicosContract.View> view;
    private Sitios_TuristicosState state;
    private Sitios_TuristicosContract.Model model;
    private Sitios_TuristicosContract.Router router;

    public Sitios_TuristicosPresenter(Sitios_TuristicosState state) {
        this.state = state;
    }

    @Override
    public void fetchSitioTuristicoListData() {
        // Log.e(TAG, "fetchCategoryListData()");

        // call the model
        model.fetchSitioTuristicoListData(new RepositoryContract.GetSitioTuristicoListCallback() {

            @Override
            public void setSitioTuristicoList(List<Sitios_TuristicosItem> sitiosTuristicosItem) {
                state.sitiosTuristicos = sitiosTuristicosItem;

                view.get().displaySitioTuristicoListData(state);
            }
        });

    }

    @Override
    public void selectSitioTuristicoListData(Sitios_TuristicosItem item) {
        router.passDataToSitioTuristicoDetailListScreen(item);
        router.navigateToSitioTuristicoDetailListScreen();
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
    public void injectView(WeakReference<Sitios_TuristicosContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Sitios_TuristicosContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Sitios_TuristicosContract.Router router) {
        this.router = router;
    }
}
