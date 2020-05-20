package com.example.gdte.tripko.idioma;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class IdiomaScreen {

    public static void configure(IdiomaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        IdiomaState state = mediator.getIdiomaState();

        IdiomaContract.Router router = new IdiomaRouter(mediator);
        IdiomaContract.Presenter presenter = new IdiomaPresenter(state);
        IdiomaContract.Model model = new IdiomaModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
