package com.example.gdte.tripko.comidarestaurante;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;

public class Comida_RestauranteListScreen {

    public static void configure(Comida_RestauranteListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Comida_RestauranteListState state = mediator.getComidaRestauranteListState();

        Comida_RestauranteListContract.Router router = new Comida_RestauranteListRouter(mediator);
        Comida_RestauranteListContract.Presenter presenter = new Comida_RestauranteListPresenter(state);
        Comida_RestauranteListContract.Model model = new Comida_RestauranteListModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
