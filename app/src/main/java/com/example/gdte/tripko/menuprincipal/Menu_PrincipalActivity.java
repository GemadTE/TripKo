package com.example.gdte.tripko.menuprincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Menu_PrincipalActivity
        extends AppCompatActivity implements Menu_PrincipalContract.View {

    public static String TAG = Menu_PrincipalActivity.class.getSimpleName();

    private Menu_PrincipalContract.Presenter presenter;

    private LinearLayout sobreCoreaBtn, idiomaBtn, conversionDeMonedaBtn, transporteBtn,
            entreteniminetoBtn, gastronomiaBtn, sitiosTuristicosBtn, contactosDeInteresBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__principal);

        sobreCoreaBtn = findViewById(R.id.sobreCorea_btn);
        idiomaBtn = findViewById(R.id.idioma_btn);
        conversionDeMonedaBtn = findViewById(R.id.conversion_de_moneda_btn);
        transporteBtn = findViewById(R.id.transporte_btn);
        entreteniminetoBtn = findViewById(R.id.entretenimiento_btn);
        gastronomiaBtn = findViewById(R.id.gastronomia_btn);
        sitiosTuristicosBtn = findViewById(R.id.sitios_turisticos_btn);
        contactosDeInteresBtn = findViewById(R.id.contactos_de_interes_btn);

        sobreCoreaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onMenuOptionClicked(0);
            }
        });
        idiomaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onMenuOptionClicked(1);
            }
        });

        conversionDeMonedaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onMenuOptionClicked(2);
            }
        });
        transporteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onMenuOptionClicked(3);
            }
        });
        entreteniminetoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onMenuOptionClicked(4);
            }
        });
        gastronomiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onMenuOptionClicked(5);
            }
        });
        sitiosTuristicosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onMenuOptionClicked(6);
            }
        });
        contactosDeInteresBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onMenuOptionClicked(7);
            }
        });

        // do the setup
        Menu_PrincipalScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(Menu_PrincipalViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
    //    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(Menu_PrincipalContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
