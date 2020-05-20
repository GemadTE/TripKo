package com.example.gdte.tripko.gastronomialist;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.data.AppRepository;
import com.example.gdte.tripko.data.RepositoryContract;

public class GastronomiaListScreen {

    public static void configure(GastronomiaListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        GastronomiaListState state = mediator.getComidaRestauranteListState();
        RepositoryContract repository = AppRepository.getInstance(context.get());

        GastronomiaListContract.Router router = new GastronomiaListRouter(mediator);
        GastronomiaListContract.Presenter presenter = new GastronomiaListPresenter(state);
        GastronomiaListContract.Model model = new GastronomiaListModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
