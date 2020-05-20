package com.example.gdte.tripko.elegiridioma;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class Elegir_IdiomaScreen {

    public static void configure(Elegir_IdiomaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        Elegir_IdiomaState state = mediator.getElegirIdiomaState();

        Elegir_IdiomaContract.Router router = new Elegir_IdiomaRouter(mediator);
        Elegir_IdiomaContract.Presenter presenter = new Elegir_IdiomaPresenter(state);
        Elegir_IdiomaContract.Model model = new ElegirI_diomaModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
