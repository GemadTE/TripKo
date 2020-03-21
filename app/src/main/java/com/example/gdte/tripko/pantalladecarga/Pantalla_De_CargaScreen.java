package com.example.gdte.tripko.pantalladecarga;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class Pantalla_De_CargaScreen {

    public static void configure(Pantalla_De_CargaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Pantalla_De_CargaState state = mediator.getPantalla_De_CargaState();

        Pantalla_De_CargaContract.Router router = new Pantalla_De_CargaRouter(mediator);
        Pantalla_De_CargaContract.Presenter presenter = new Pantalla_De_CargaPresenter(state);
        Pantalla_De_CargaContract.Model model = new Pantalla_De_CargaModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
