package com.example.gdte.tripko.regiones;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.data.AppRepository;
import com.example.gdte.tripko.data.RepositoryContract;

public class Region_ListScreen {

    public static void configure(Region_ListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        Region_ListState state = mediator.getRegionListState();

        RepositoryContract repository = AppRepository.getInstance(context.get());

        Region_ListContract.Router router = new Region_ListRouter(mediator);
        Region_ListContract.Presenter presenter = new Region_ListPresenter(state);
        Region_ListContract.Model model = new Region_ListModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
