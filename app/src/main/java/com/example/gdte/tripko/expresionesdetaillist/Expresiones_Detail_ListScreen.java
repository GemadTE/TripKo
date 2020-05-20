package com.example.gdte.tripko.expresionesdetaillist;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class Expresiones_Detail_ListScreen {

    public static void configure(Expresiones_Detail_ListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        Expresiones_Detail_ListState state = mediator.getExpresionesDetailListState();

        Expresiones_Detail_ListContract.Router router = new Expresiones_Detail_ListRouter(mediator);
        Expresiones_Detail_ListContract.Presenter presenter = new Expresiones_Detail_ListPresenter(state);
        Expresiones_Detail_ListContract.Model model = new Expresiones_Detail_ListModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
