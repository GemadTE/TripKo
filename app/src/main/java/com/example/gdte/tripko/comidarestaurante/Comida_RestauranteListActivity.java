package com.example.gdte.tripko.comidarestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Comida_RestauranteListActivity
        extends AppCompatActivity implements Comida_RestauranteListContract.View {

    public static String TAG = Comida_RestauranteListActivity.class.getSimpleName();

    private Comida_RestauranteListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida_restaurante);


        // do the setup
        Comida_RestauranteListScreen.configure(this);

        if (savedInstanceState == null) {
            presenter.onStart();

        } else {
            presenter.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        presenter.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

    @Override
    public void onDataUpdated(Comida_RestauranteListViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data

    }

    @Override
    public void injectPresenter(Comida_RestauranteListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
