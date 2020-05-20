package com.example.gdte.tripko.menuprincipal;

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
import com.example.gdte.tripko.contactosdeinteres.Contactos_De_InteresActivity;
import com.example.gdte.tripko.conversormoneda.Conversor_MonedaActivity;
import com.example.gdte.tripko.entretenimiento.EntretenimientoActivity;
import com.example.gdte.tripko.idioma.IdiomaActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;
import com.example.gdte.tripko.regiones.Region_ListActivity;
import com.example.gdte.tripko.sitiosturisticos.Sitios_TuristicosActivity;
import com.example.gdte.tripko.sobrecorea.Sobre_CoreaActivity;
import com.example.gdte.tripko.transportecategory.Transporte_CategoryActivity;

public class Menu_PrincipalActivity
        extends AppCompatActivity implements Menu_PrincipalContract.View {

    public static String TAG = Menu_PrincipalActivity.class.getSimpleName();

    private Menu_PrincipalContract.Presenter presenter;

    private LinearLayout sobreCoreaBtn, idiomaBtn, conversionDeMonedaBtn, transporteBtn,
            entreteniminetoBtn, gastronomiaBtn, sitiosTuristicosBtn, contactosDeInteresBtn;

    private ImageButton preguntasFrecuentesImageButton;

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

        preguntasFrecuentesImageButton = findViewById(R.id.preguntasFrecuentesImageButton);

        if (savedInstanceState == null) AppMediator.resetInstance();

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

        preguntasFrecuentesImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPreguntasFrecuentesClicked();
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
    public void navigateToSobreCoreaScreen() {
        Intent intent = new Intent(this, Sobre_CoreaActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToIdiomaScreen() {
        Intent intent = new Intent(this, IdiomaActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToConversionDeMonedaScreen() {
        Intent intent = new Intent(this, Conversor_MonedaActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToTransporteScreen() {
        Intent intent = new Intent(this, Transporte_CategoryActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToEntretenimientoScreen() {
        Intent intent = new Intent(this, EntretenimientoActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToGastronomiaScreen() {
        Intent intent = new Intent(this, Region_ListActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToSitiosTuristicosScreen() {
        Intent intent = new Intent(this, Sitios_TuristicosActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToContactosDeInteresScreen() {
        Intent intent = new Intent(this, Contactos_De_InteresActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToPreguntasFrecuentesScreen() {
        Intent intent = new Intent(this, Preguntas_FrecuentesActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Menu_PrincipalContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
