package com.example.gdte.tripko.tiposdesitiosturisticos;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class Tipos_De_Sitios_TuristicosScreen {

    public static void configure(Tipos_De_Sitios_TuristicosContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Tipos_De_Sitios_TuristicosState state = mediator.getTiposDeSitiosTuristicosState();

        Tipos_De_Sitios_TuristicosContract.Router router = new Tipos_De_Sitios_TuristicosRouter(mediator);
        Tipos_De_Sitios_TuristicosContract.Presenter presenter = new Tipos_De_Sitios_TuristicosPresenter(state);
        Tipos_De_Sitios_TuristicosContract.Model model = new Tipos_De_Sitios_TuristicosModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
