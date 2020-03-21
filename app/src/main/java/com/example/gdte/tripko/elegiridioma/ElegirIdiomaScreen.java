package com.example.gdte.tripko.elegiridioma;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class ElegirIdiomaScreen {

    public static void configure(ElegirIdiomaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ElegirIdiomaState state = mediator.getElegirIdiomaState();

        ElegirIdiomaContract.Router router = new ElegirIdiomaRouter(mediator);
        ElegirIdiomaContract.Presenter presenter = new ElegirIdiomaPresenter(state);
        ElegirIdiomaContract.Model model = new ElegirIdiomaModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
