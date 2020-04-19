package com.example.gdte.tripko.entretenimientodetaillist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Entretenimiento_Detail_ListActivity
        extends AppCompatActivity implements Entretenimiento_Detail_ListContract.View {

    public static String TAG = Entretenimiento_Detail_ListActivity.class.getSimpleName();

    private Entretenimiento_Detail_ListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entretenimiento__detail__list);
        getSupportActionBar().setTitle(R.string.app_name);

        // do the setup
        Entretenimiento_Detail_ListScreen.configure(this);

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
    public void onDataUpdated(Entretenimiento_Detail_ListViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(Entretenimiento_Detail_ListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
