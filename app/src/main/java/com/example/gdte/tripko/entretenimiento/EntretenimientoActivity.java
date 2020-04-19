package com.example.gdte.tripko.entretenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class EntretenimientoActivity
        extends AppCompatActivity implements EntretenimientoContract.View {

    public static String TAG = EntretenimientoActivity.class.getSimpleName();

    private EntretenimientoContract.Presenter presenter;
    private ImageButton preguntasFrecuentesImageButton, homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entretenimiento);

        // do the setup
        EntretenimientoScreen.configure(this);
        preguntasFrecuentesImageButton=findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton=findViewById(R.id.homeImageButton);

        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goHomeButtonClicked();
            }
        });

        preguntasFrecuentesImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goPreguntasFrecuentesButtonClicked();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(EntretenimientoViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data

    }

    @Override
    public void injectPresenter(EntretenimientoContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
