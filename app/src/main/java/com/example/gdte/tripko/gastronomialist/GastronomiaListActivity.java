package com.example.gdte.tripko.gastronomialist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.gdte.tripko.R;

public class GastronomiaListActivity
        extends AppCompatActivity implements GastronomiaListContract.View {

    public static String TAG = GastronomiaListActivity.class.getSimpleName();

    private GastronomiaListContract.Presenter presenter;

    private ImageButton preguntasFrecuentesImageButton,homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomia_list);

        preguntasFrecuentesImageButton = findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton = findViewById(R.id.homeImageButton);

        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goHomeButtonClicked();
            }
        });

        // do the setup
        GastronomiaListScreen.configure(this);

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
    public void onDataUpdated(GastronomiaListViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data

    }

    @Override
    public void injectPresenter(GastronomiaListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
