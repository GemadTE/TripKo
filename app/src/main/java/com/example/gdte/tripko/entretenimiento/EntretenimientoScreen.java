package com.example.gdte.tripko.entretenimiento;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

public class EntretenimientoScreen {

    public static void configure(EntretenimientoContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        EntretenimientoState state = mediator.getEntretenimientoState();

        EntretenimientoContract.Router router = new EntretenimientoRouter(mediator);
        EntretenimientoContract.Presenter presenter = new EntretenimientoPresenter(state);
        EntretenimientoContract.Model model = new EntretenimientoModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
