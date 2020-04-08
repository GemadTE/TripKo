package com.example.gdte.tripko.gastronomiaregiones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.gdte.tripko.R;

public class Gastronomia_RegionesActivity
        extends AppCompatActivity implements Gastronomia_RegionesContract.View {

    public static String TAG = Gastronomia_RegionesActivity.class.getSimpleName();

    private Gastronomia_RegionesContract.Presenter presenter;

    Button gangwonButton;

    private ImageButton menuDesplegableImageButton,homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomia_regiones);

        // do the setup
        Gastronomia_RegionesScreen.configure(this);

        gangwonButton = findViewById(R.id.gangwonButton);

        menuDesplegableImageButton = findViewById(R.id.menuDesplegableImageButton);
        homeImageButton = findViewById(R.id.homeImageButton);

        gangwonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goMenuButtonClicked();
            }
        });

        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goHomeButtonClicked();
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
    public void onDataUpdated(Gastronomia_RegionesViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
    }

    @Override
    public void injectPresenter(Gastronomia_RegionesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
