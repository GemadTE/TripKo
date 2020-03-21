package com.example.gdte.tripko.sobrecorea;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class Sobre_CoreaScreen {

    public static void configure(Sobre_CoreaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Sobre_CoreaState state = mediator.getSobre_CoreaState();

        Sobre_CoreaContract.Router router = new Sobre_CoreaRouter(mediator);
        Sobre_CoreaContract.Presenter presenter = new Sobre_CoreaPresenter(state);
        Sobre_CoreaContract.Model model = new Sobre_CoreaModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
