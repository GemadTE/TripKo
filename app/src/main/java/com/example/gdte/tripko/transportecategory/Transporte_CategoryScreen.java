package com.example.gdte.tripko.transportecategory;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;

public class Transporte_CategoryScreen {

    public static void configure(Transporte_CategoryContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();
        Transporte_CategoryState state = mediator.getTransporteCategoryState();

        Transporte_CategoryContract.Router router = new Transporte_CategoryRouter(mediator);
        Transporte_CategoryContract.Presenter presenter = new Transporte_CategoryPresenter(state);
        Transporte_CategoryContract.Model model = new Transporte_CategoryModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
