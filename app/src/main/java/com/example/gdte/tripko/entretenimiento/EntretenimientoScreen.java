package com.example.gdte.tripko.entretenimiento;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.data.AppRepository;
import com.example.gdte.tripko.data.RepositoryContract;

public class EntretenimientoScreen {

    public static void configure(EntretenimientoContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        EntretenimientoState state = mediator.getEntretenimientoState();
        RepositoryContract repository = AppRepository.getInstance(context.get());


        EntretenimientoContract.Router router = new EntretenimientoRouter(mediator);
        EntretenimientoContract.Presenter presenter = new EntretenimientoPresenter(state);
        EntretenimientoContract.Model model = new EntretenimientoModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
