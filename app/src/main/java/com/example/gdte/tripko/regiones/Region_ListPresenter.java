package com.example.gdte.tripko.regiones;

import com.example.gdte.tripko.data.RegionItem;
import com.example.gdte.tripko.data.RepositoryContract;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Region_ListPresenter implements Region_ListContract.Presenter {

    public static String TAG = Region_ListPresenter.class.getSimpleName();

    private WeakReference<Region_ListContract.View> view;
    private Region_ListState state;
    private Region_ListContract.Model model;
    private Region_ListContract.Router router;

    public Region_ListPresenter(Region_ListState state) {
        this.state = state;
    }

    @Override
    public void fetchRegionListData() {
        // Log.e(TAG, "onStart()");

        //call the model
        model.fetchRegionListData(new RepositoryContract.GetRegionListCallback() {

            @Override
            public void setRegionList(List<RegionItem> regiones) {
               state.regiones = regiones;

                view.get().displayRegionListData(state);
            }
        });

    }

    @Override
    public void selectRegionListData(RegionItem item) {
        router.passDataToGastronomiaListScreen(item);
        router.navigateToGastronomiaListScreen();
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
    public void injectView(WeakReference<Region_ListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Region_ListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(Region_ListContract.Router router) {
        this.router = router;
    }
}
