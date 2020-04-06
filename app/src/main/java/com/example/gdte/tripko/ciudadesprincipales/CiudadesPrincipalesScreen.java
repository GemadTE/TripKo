package com.example.gdte.tripko.ciudadesprincipales;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

public class CiudadesPrincipalesScreen {

    public static void configure(CiudadesPrincipalesContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        CiudadesPrincipalesState state = mediator.getCiudadesPrincipalesState();

        CiudadesPrincipalesContract.Router router = new CiudadesPrincipalesRouter(mediator);
        CiudadesPrincipalesContract.Presenter presenter = new CiudadesPrincipalesPresenter(state);
        CiudadesPrincipalesContract.Model model = new CiudadesPrincipalesModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
