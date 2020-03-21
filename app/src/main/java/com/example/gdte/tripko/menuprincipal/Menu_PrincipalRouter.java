package com.example.gdte.tripko.menuprincipal;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.gdte.tripko.app.AppMediator;

public class Menu_PrincipalRouter implements Menu_PrincipalContract.Router {

    public static String TAG = Menu_PrincipalRouter.class.getSimpleName();

    private AppMediator mediator;

    public Menu_PrincipalRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, Menu_PrincipalActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(Menu_PrincipalState state) {
        mediator.setMenu_PrincipalState(state);
    }

    @Override
    public Menu_PrincipalState getDataFromPreviousScreen() {
        Menu_PrincipalState state = mediator.getMenu_PrincipalState();
        return state;
    }
}
