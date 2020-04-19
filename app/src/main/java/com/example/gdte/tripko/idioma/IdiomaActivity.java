package com.example.gdte.tripko.idioma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class IdiomaActivity
        extends AppCompatActivity implements IdiomaContract.View {

    public static String TAG = IdiomaActivity.class.getSimpleName();

    private IdiomaContract.Presenter presenter;
    private LinearLayout idiomaCoreanoBtn, alfabetoBtn, expresionesBtn;
    private ImageButton preguntasFrecuentesImageButton, homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma);

        idiomaCoreanoBtn = findViewById(R.id.idioma_coreano_btn);
        alfabetoBtn = findViewById(R.id.alfabeto_btn);
        expresionesBtn = findViewById(R.id.expresiones_btn);

        preguntasFrecuentesImageButton = findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton = findViewById(R.id.homeImageButton);

        idiomaCoreanoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onIdiomaOptionClicked(0);
            }
        });

        alfabetoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onIdiomaOptionClicked(1);
            }
        });

        expresionesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onIdiomaOptionClicked(2);
            }
        });

        preguntasFrecuentesImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPreguntasFrecuentesClicked();
            }
        });
        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goHomeButtonClicked();
            }
        });

        // do the setup
        IdiomaScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(IdiomaViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        // ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(IdiomaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
