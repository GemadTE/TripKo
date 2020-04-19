package com.example.gdte.tripko.culturadetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Cultura_DetailActivity
        extends AppCompatActivity implements Cultura_DetailContract.View {

    public static String TAG = Cultura_DetailActivity.class.getSimpleName();

    private Cultura_DetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultura__detail);
        getSupportActionBar().setTitle(R.string.app_name);

        // do the setup
        Cultura_DetailScreen.configure(this);

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
    public void onDataUpdated(Cultura_DetailViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(Cultura_DetailContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
