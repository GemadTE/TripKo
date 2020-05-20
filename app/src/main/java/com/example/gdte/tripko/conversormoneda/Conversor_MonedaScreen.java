package com.example.gdte.tripko.conversormoneda;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;

public class Conversor_MonedaScreen {

    public static void configure(Conversor_MonedaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();
        Conversor_MonedaState state = mediator.getConversorMonedaState();

        Conversor_MonedaContract.Router router = new Conversor_MonedaRouter(mediator);
        Conversor_MonedaContract.Presenter presenter = new Conversor_MonedaPresenter(state);
        Conversor_MonedaContract.Model model = new Conversor_MonedaModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
