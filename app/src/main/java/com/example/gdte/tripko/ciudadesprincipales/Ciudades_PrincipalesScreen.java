package com.example.gdte.tripko.ciudadesprincipales;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class Ciudades_PrincipalesScreen {

    public static void configure(Ciudades_PrincipalesContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);
        AppMediator mediator = AppMediator.getInstance();
        Ciudades_PrincipalesState state = mediator.getCiudadesPrincipalesState();

        Ciudades_PrincipalesContract.Router router = new Ciudades_PrincipalesRouter(mediator);
        Ciudades_PrincipalesContract.Presenter presenter = new Ciudades_PrincipalesPresenter(state);
        Ciudades_PrincipalesContract.Model model = new Ciudades_PrincipalesModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
