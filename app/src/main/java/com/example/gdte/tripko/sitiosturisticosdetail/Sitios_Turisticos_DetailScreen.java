package com.example.gdte.tripko.sitiosturisticosdetail;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.data.RepositoryContract;

public class Sitios_Turisticos_DetailScreen {

    public static void configure(Sitios_Turisticos_DetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();
        Sitios_Turisticos_DetailState state = mediator.getSitiosTuristicosDetailState();

        Sitios_Turisticos_DetailContract.Router router = new Sitios_Turisticos_DetailRouter(mediator);
        Sitios_Turisticos_DetailContract.Presenter presenter = new Sitios_Turisticos_DetailPresenter(state);
        Sitios_Turisticos_DetailContract.Model model = new Sitios_Turisticos_DetailModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
