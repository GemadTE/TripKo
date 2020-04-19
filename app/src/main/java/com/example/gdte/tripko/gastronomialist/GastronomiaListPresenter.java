package com.example.gdte.tripko.gastronomialist;

import com.example.gdte.tripko.data.GastronomiaItem;
import com.example.gdte.tripko.data.RegionItem;
import com.example.gdte.tripko.data.RepositoryContract;

import java.lang.ref.WeakReference;
import java.util.List;

public class GastronomiaListPresenter implements GastronomiaListContract.Presenter {

    public static String TAG = GastronomiaListPresenter.class.getSimpleName();

    private WeakReference<GastronomiaListContract.View> view;
    private GastronomiaListState state;
    private GastronomiaListContract.Model model;
    private GastronomiaListContract.Router router;

    public GastronomiaListPresenter(GastronomiaListState state) {
        this.state = state;
    }

    @Override
    public void fetchProductListData() {
        // Log.e(TAG, "fetchProductListData()");

        // set passed state
        RegionItem regionItem = router.getDataFromRegionListScreen();

        if (regionItem != null) {
            state.region = regionItem;
        }

        // call the model
        model.fetchGastronomiaListData(state.region,
                new RepositoryContract.GetGastronomiaListCallback() {

                    @Override
                    public void setGastronomiaList(List<GastronomiaItem> gastronomiaItems) {
                        state.gastronomiaItems = gastronomiaItems;

                        view.get().displayProductListData(state);
                    }
                });

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
    public void selectGastronomiaListData(GastronomiaItem item) {
        router.passDataToGastronomiaDetailListScreen(item);
        router.navigateToGastronomiaDetailListScreen();
    }

    @Override
    public void injectView(WeakReference<GastronomiaListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(GastronomiaListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(GastronomiaListContract.Router router) {
        this.router = router;
    }
}
