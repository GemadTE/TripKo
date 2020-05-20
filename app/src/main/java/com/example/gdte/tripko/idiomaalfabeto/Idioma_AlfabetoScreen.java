package com.example.gdte.tripko.idiomaalfabeto;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class Idioma_AlfabetoScreen {

    public static void configure(Idioma_AlfabetoContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        Idioma_AlfabetoState state = mediator.getIdiomaAlfabetoState();

        Idioma_AlfabetoContract.Router router = new Idioma_AlfabetoRouter(mediator);
        Idioma_AlfabetoContract.Presenter presenter = new Idioma_AlfabetoPresenter(state);
        Idioma_AlfabetoContract.Model model = new Idioma_AlfabetoModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
