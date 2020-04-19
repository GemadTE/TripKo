package com.example.gdte.tripko.idiomacoreano;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class Idioma_CoreanoScreen {

    public static void configure(Idioma_CoreanoContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Idioma_CoreanoState state = mediator.getIdiomaCoreanoState();

        Idioma_CoreanoContract.Router router = new Idioma_CoreanoRouter(mediator);
        Idioma_CoreanoContract.Presenter presenter = new Idioma_CoreanoPresenter(state);
        Idioma_CoreanoContract.Model model = new Idioma_CoreanoModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
