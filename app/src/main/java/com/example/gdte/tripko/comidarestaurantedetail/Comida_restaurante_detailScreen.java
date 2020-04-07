package com.example.gdte.tripko.comidarestaurantedetail;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;

public class Comida_restaurante_detailScreen {

    public static void configure(Comida_restaurante_detailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Comida_restaurante_detailState state = mediator.getComidarestaurantedetailState();

        Comida_restaurante_detailContract.Router router = new Comida_restaurante_detailRouter(mediator);
        Comida_restaurante_detailContract.Presenter presenter = new Comida_restaurante_detailPresenter(state);
        Comida_restaurante_detailContract.Model model = new Comida_restaurante_detailModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
