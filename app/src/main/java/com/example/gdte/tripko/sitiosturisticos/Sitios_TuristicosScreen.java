package com.example.gdte.tripko.sitiosturisticos;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

public class Sitios_TuristicosScreen {

    public static void configure(Sitios_TuristicosContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Sitios_TuristicosState state = mediator.getSitios_TuristicosState();

        Sitios_TuristicosContract.Router router = new Sitios_TuristicosRouter(mediator);
        Sitios_TuristicosContract.Presenter presenter = new Sitios_TuristicosPresenter(state);
        Sitios_TuristicosContract.Model model = new Sitios_TuristicosModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
