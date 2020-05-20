package com.example.gdte.tripko.preguntasfrecuentes;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;

public class Preguntas_FrecuentesScreen {

    public static void configure(Preguntas_FrecuentesContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();
        Preguntas_FrecuentesState state = mediator.getPreguntasFrecuentesState();

        Preguntas_FrecuentesContract.Router router = new Preguntas_FrecuentesRouter(mediator);
        Preguntas_FrecuentesContract.Presenter presenter = new Preguntas_FrecuentesPresenter(state);
        Preguntas_FrecuentesContract.Model model = new Preguntas_FrecuentesModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
