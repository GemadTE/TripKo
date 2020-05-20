package com.example.gdte.tripko.clima;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class ClimaScreen {

    public static void configure(ClimaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        ClimaState state = mediator.getClimaState();

        ClimaContract.Router router = new ClimaRouter(mediator);
        ClimaContract.Presenter presenter = new ClimaPresenter(state);
        ClimaContract.Model model = new ClimaModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
