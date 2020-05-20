package com.example.gdte.tripko.idioma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.expresionesdetaillist.Expresiones_Detail_ListActivity;
import com.example.gdte.tripko.idiomaalfabeto.Idioma_AlfabetoActivity;
import com.example.gdte.tripko.idiomacoreano.Idioma_CoreanoActivity;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

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

        if (savedInstanceState == null) AppMediator.resetInstance();

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
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, IdiomaActivity.class);
        startActivity(intent);
    }


    @Override
    public void navigateToIdiomaCoreanoScreen() {
        Intent intent = new Intent(this, Idioma_CoreanoActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToIdiomaAlfabetoScreen() {
        Intent intent = new Intent(this, Idioma_AlfabetoActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToExpresionesDetailListScreen() {
        Intent intent = new Intent(this, Expresiones_Detail_ListActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToPreguntasFrecuentesScreen() {
        Intent intent = new Intent(this, Preguntas_FrecuentesActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToHomeScreen() {
        Intent intent = new Intent(this, Menu_PrincipalActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(IdiomaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
