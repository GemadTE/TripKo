package com.example.gdte.tripko.transportecategory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Transporte_CategoryActivity
        extends AppCompatActivity implements Transporte_CategoryContract.View {

    public static String TAG = Transporte_CategoryActivity.class.getSimpleName();

    private Transporte_CategoryContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporte__category);

        // do the setup
        Transporte_CategoryScreen.configure(this);

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
    public void onDataUpdated(Transporte_CategoryViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data

    }

    @Override
    public void injectPresenter(Transporte_CategoryContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
