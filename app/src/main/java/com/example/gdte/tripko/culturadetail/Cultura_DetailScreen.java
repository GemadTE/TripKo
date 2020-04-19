package com.example.gdte.tripko.culturadetail;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;

public class Cultura_DetailScreen {

    public static void configure(Cultura_DetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        Cultura_DetailState state = mediator.getCulturaDetailState();

        Cultura_DetailContract.Router router = new Cultura_DetailRouter(mediator);
        Cultura_DetailContract.Presenter presenter = new Cultura_DetailPresenter(state);
        Cultura_DetailContract.Model model = new Cultura_DetailModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
