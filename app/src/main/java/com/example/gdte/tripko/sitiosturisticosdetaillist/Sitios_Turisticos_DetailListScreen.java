package com.example.gdte.tripko.sitiosturisticosdetaillist;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.data.AppRepository;
import com.example.gdte.tripko.data.RepositoryContract;

public class Sitios_Turisticos_DetailListScreen {

    public static void configure(Sitios_Turisticos_DetailListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = AppMediator.getInstance();
        Sitios_Turisticos_DetailListState state = mediator.getTiposDeSitiosTuristicosState();
        RepositoryContract repository = AppRepository.getInstance(context.get());

        Sitios_Turisticos_DetailListContract.Router router = new Sitios_Turisticos_DetailListRouter(mediator);
        Sitios_Turisticos_DetailListContract.Presenter presenter = new Sitios_Turisticos_DetailListPresenter(state);
        Sitios_Turisticos_DetailListContract.Model model = new Sitios_Turisticos_DetailListModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
