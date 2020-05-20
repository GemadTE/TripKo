package com.example.gdte.tripko.sitiosturisticosdetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Sitios_Turisticos_DetailActivity
        extends AppCompatActivity implements Sitios_Turisticos_DetailContract.View {

    public static String TAG = Sitios_Turisticos_DetailActivity.class.getSimpleName();

    private Sitios_Turisticos_DetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios__turisticos__detail);


        // do the setup
        Sitios_Turisticos_DetailScreen.configure(this);

        if (savedInstanceState == null) {
            presenter.onStart();

        } else {
            presenter.onRestart();
        }
    }

    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, Sitios_Turisticos_DetailActivity.class);
        startActivity(intent);
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
    public void onDataUpdated(Sitios_Turisticos_DetailViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");


    }

    @Override
    public void injectPresenter(Sitios_Turisticos_DetailContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
