package com.example.gdte.tripko.contactosdeinteres;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;

public class Contactos_De_InteresScreen {

    public static void configure(Contactos_De_InteresContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Contactos_De_InteresState state = mediator.getContactosDeInteresState();

        Contactos_De_InteresContract.Router router = new Contactos_De_InteresRouter(mediator);
        Contactos_De_InteresContract.Presenter presenter = new Contactos_De_InteresPresenter(state);
        Contactos_De_InteresContract.Model model = new Contactos_De_InteresModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
