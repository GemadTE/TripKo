package com.example.gdte.tripko.gastronomiadetaillist;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.data.AppRepository;
import com.example.gdte.tripko.data.RepositoryContract;

public class Gastronomia_Detail_ListScreen {

    public static void configure(Gastronomia_Detail_ListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Gastronomia_Detail_ListState state = mediator.getComidarestaurantedetailState();
        RepositoryContract repository = AppRepository.getInstance(context.get());


        Gastronomia_Detail_ListContract.Router router = new Gastronomia_Detail_ListRouter(mediator);
        Gastronomia_Detail_ListContract.Presenter presenter = new Gastronomia_Detail_ListPresenter(state);
        Gastronomia_Detail_ListContract.Model model = new Gastronomia_Detail_ListModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
