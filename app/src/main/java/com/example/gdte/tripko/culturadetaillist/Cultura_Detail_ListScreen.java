package com.example.gdte.tripko.culturadetaillist;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;

public class Cultura_Detail_ListScreen {

    public static void configure(Cultura_Detail_ListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Cultura_Detail_ListState state = mediator.getCulturaDetailListState();

        Cultura_Detail_ListContract.Router router = new Cultura_Detail_ListRouter(mediator);
        Cultura_Detail_ListContract.Presenter presenter = new Cultura_Detail_ListPresenter(state);
        Cultura_Detail_ListContract.Model model = new Cultura_Detail_ListModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
