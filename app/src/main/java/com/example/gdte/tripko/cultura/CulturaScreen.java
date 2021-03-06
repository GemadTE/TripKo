package com.example.gdte.tripko.cultura;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class CulturaScreen {

    public static void configure(CulturaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        CulturaState state = mediator.getCulturaState();

        CulturaContract.Router router = new CulturaRouter(mediator);
        CulturaContract.Presenter presenter = new CulturaPresenter(state);
        CulturaContract.Model model = new CulturaModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
