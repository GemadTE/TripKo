package com.example.gdte.tripko.gastronomialist;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;

public class GastronomiaListScreen {

    public static void configure(GastronomiaListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        GastronomiaListState state = mediator.getComidaRestauranteListState();

        GastronomiaListContract.Router router = new GastronomiaListRouter(mediator);
        GastronomiaListContract.Presenter presenter = new GastronomiaListPresenter(state);
        GastronomiaListContract.Model model = new GastronomiaListModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
