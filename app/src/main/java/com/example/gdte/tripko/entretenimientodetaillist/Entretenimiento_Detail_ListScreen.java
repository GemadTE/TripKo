package com.example.gdte.tripko.entretenimientodetaillist;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;

public class Entretenimiento_Detail_ListScreen {

    public static void configure(Entretenimiento_Detail_ListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();
        Entretenimiento_Detail_ListState state = mediator.getEntretenimientoDetailListState();

        Entretenimiento_Detail_ListContract.Router router = new Entretenimiento_Detail_ListRouter(mediator);
        Entretenimiento_Detail_ListContract.Presenter presenter = new Entretenimiento_Detail_ListPresenter(state);
        Entretenimiento_Detail_ListContract.Model model = new Entretenimiento_Detail_ListModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
