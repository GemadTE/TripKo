package com.example.gdte.tripko.sitiosturisticos;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.data.AppRepository;
import com.example.gdte.tripko.data.RepositoryContract;

public class Sitios_TuristicosScreen {

    public static void configure(Sitios_TuristicosContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Sitios_TuristicosState state = mediator.getSitiosTuristicosState();
        RepositoryContract repository = AppRepository.getInstance(context.get());



        Sitios_TuristicosContract.Router router = new Sitios_TuristicosRouter(mediator);
        Sitios_TuristicosContract.Presenter presenter = new Sitios_TuristicosPresenter(state);
        Sitios_TuristicosContract.Model model = new Sitios_TuristicosModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
