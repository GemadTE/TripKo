package com.example.gdte.tripko.splash;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.gdte.tripko.app.AppMediator;

public class SplashScreen {

    public static void configure(SplashContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        SplashState state = mediator.getSplashState();

        SplashContract.Router router = new SplashRouter(mediator);
        SplashContract.Presenter presenter = new SplashPresenter(state);
        SplashContract.Model model = new SplashModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
