package com.example.gdte.tripko.gastronomiaregiones;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;

public class Gastronomia_RegionesScreen {

    public static void configure(Gastronomia_RegionesContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Gastronomia_Gastronomia_RegionesState state = mediator.getGastronomiaRegionesState();

        Gastronomia_RegionesContract.Router router = new Gastronomia_RegionesRouter(mediator);
        Gastronomia_RegionesContract.Presenter presenter = new Gastronomia_RegionesPresenter(state);
        Gastronomia_RegionesContract.Model model = new Gastronomia_RegionesModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
