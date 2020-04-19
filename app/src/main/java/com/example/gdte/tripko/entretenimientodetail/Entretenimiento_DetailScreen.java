package com.example.gdte.tripko.entretenimientodetail;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;

public class Entretenimiento_DetailScreen {

    public static void configure(Entretenimiento_DetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Entretenimiento_DetailState state = mediator.getEntretenimientoDetailState();

        Entretenimiento_DetailContract.Router router = new Entretenimiento_DetailRouter(mediator);
        Entretenimiento_DetailContract.Presenter presenter = new Entretenimiento_DetailPresenter(state);
        Entretenimiento_DetailContract.Model model = new Entretenimiento_DetailModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
