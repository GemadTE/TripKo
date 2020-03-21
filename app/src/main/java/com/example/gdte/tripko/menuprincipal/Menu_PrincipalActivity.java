package com.example.gdte.tripko.menuprincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Menu_PrincipalActivity
        extends AppCompatActivity implements Menu_PrincipalContract.View {

    public static String TAG = Menu_PrincipalActivity.class.getSimpleName();

    private Menu_PrincipalContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__principal);

        // do the setup
        Menu_PrincipalScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(Menu_PrincipalViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(Menu_PrincipalContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
