package com.example.gdte.tripko.regiones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class RegionesActivity
        extends AppCompatActivity implements RegionesContract.View {

    public static String TAG = RegionesActivity.class.getSimpleName();

    private RegionesContract.Presenter presenter;

    Button gangwonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiones);

        // do the setup
        RegionesScreen.configure(this);

        gangwonButton = findViewById(R.id.gangwonButton);

        gangwonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goMenuButtonClicked();
            }
        });

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
    public void onDataUpdated(RegionesViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
    }

    @Override
    public void injectPresenter(RegionesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
