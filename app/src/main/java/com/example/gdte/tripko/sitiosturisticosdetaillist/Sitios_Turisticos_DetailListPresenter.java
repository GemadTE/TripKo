package com.example.gdte.tripko.sitiosturisticosdetaillist;

import com.example.gdte.tripko.data.RepositoryContract;
import com.example.gdte.tripko.data.Sitios_TuristicosDetailItem;
import com.example.gdte.tripko.data.Sitios_TuristicosItem;

import java.lang.ref.WeakReference;
import java.util.List;

public class Sitios_Turisticos_DetailListPresenter implements Sitios_Turisticos_DetailListContract.Presenter {

    public static String TAG = Sitios_Turisticos_DetailListPresenter.class.getSimpleName();

    private WeakReference<Sitios_Turisticos_DetailListContract.View> view;
    private Sitios_Turisticos_DetailListState state;
    private Sitios_Turisticos_DetailListContract.Model model;
    private Sitios_Turisticos_DetailListContract.Router router;

    public Sitios_Turisticos_DetailListPresenter(Sitios_Turisticos_DetailListState state) {
        this.state = state;
    }

    @Override
    public void fetchSitiosTuristicosDetailListData() {
        // Log.e(TAG, "fetchProductListData()");

        // set passed state
        Sitios_TuristicosItem sitiosTuristicosItem = router.getDataFromSitiosTuristicosListScreen();

        if (sitiosTuristicosItem != null) {
            state.sitiosTuristicosItem = sitiosTuristicosItem;
        }

        // call the model
        model.fetchSitiosTuristicosListData(state.sitiosTuristicosItem,
                new RepositoryContract.GetSitioTuristicoDetailListCallback() {

                    @Override
                    public void setSitioTuristicoDetailList(List<Sitios_TuristicosDetailItem> sitiosTuristicosDetailItems) {
                        state.sitios_turisticosDetailItemList = sitiosTuristicosDetailItems;

                        view.get().displayProductListData(state);
                    }
                });

    }

    @Override
    public void selectSitioTuristicoDetailListData(Sitios_TuristicosDetailItem item) {
        router.passDataToSitioTuristicoDetailScreen(item);
        router.navigateToSitioTuristicoDetailScreen();
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
    public void injectView(WeakReference<Sitios_Turisticos_DetailListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Sitios_Turisticos_DetailListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Sitios_Turisticos_DetailListContract.Router router) {
        this.router = router;
    }
}
