package com.example.gdte.tripko.menuprincipal;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class Menu_PrincipalScreen {

    public static void configure(Menu_PrincipalContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Menu_PrincipalState state = mediator.getMenu_PrincipalState();

        Menu_PrincipalContract.Router router = new Menu_PrincipalRouter(mediator);
        Menu_PrincipalContract.Presenter presenter = new Menu_PrincipalPresenter(state);
        Menu_PrincipalContract.Model model = new Menu_PrincipalModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
