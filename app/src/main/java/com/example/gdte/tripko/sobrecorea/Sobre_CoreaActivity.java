package com.example.gdte.tripko.sobrecorea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.ciudadesprincipales.Ciudades_PrincipalesActivity;
import com.example.gdte.tripko.clima.ClimaActivity;
import com.example.gdte.tripko.cultura.CulturaActivity;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;
import com.example.gdte.tripko.sitiosturisticos.Sitios_TuristicosScreen;

public class Sobre_CoreaActivity
        extends AppCompatActivity implements Sobre_CoreaContract.View {

    public static String TAG = Sobre_CoreaActivity.class.getSimpleName();

    private Sobre_CoreaContract.Presenter presenter;
    private TextView sobreCoreaTitle,sobreCoreaDescriptionText;
    private ImageView image1, image2;
    private Button climaButton, culturaButton, ciudadesPrincipalesButton;
    private ImageButton preguntasFrecuentesImageButton, homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre__corea);

        // do the setup
        Sobre_CoreaScreen.configure(this);

        preguntasFrecuentesImageButton=findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton=findViewById(R.id.homeImageButton);

        sobreCoreaDescriptionText=findViewById(R.id.sobreCoreaDescriptionText);
        sobreCoreaTitle=findViewById(R.id.sobreCoreaTitle);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        climaButton=findViewById(R.id.climaButton);
        culturaButton=findViewById(R.id.culturaButton);
        ciudadesPrincipalesButton=findViewById(R.id.ciudadesPrincipalesButton);


        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goHomeButtonClicked();
            }
        });


        climaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goClimaButtonClicked();
            }
        });

        ciudadesPrincipalesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goCiudadesPrincipalesButtonClicked();
            }
        });

        culturaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goCulturaButtonClicked();
            }
        });

        preguntasFrecuentesImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goPreguntasFrecuentesButtonClicked();
            }
        });


        // do the setup
        Sobre_CoreaScreen.configure(this);

    }

    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, Sobre_CoreaActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToHomeScreen() {
        Intent intent = new Intent(this, Menu_PrincipalActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToPreguntasFrecuentesScreen() {
        Intent intent = new Intent(this, Preguntas_FrecuentesActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToClimaScreen() {
        Intent intent = new Intent(this, ClimaActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToCiudadesPrincipalesScreen() {
        Intent intent = new Intent(this, Ciudades_PrincipalesActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToCulturaScreen() {
        Intent intent = new Intent(this, CulturaActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(Sobre_CoreaViewModel viewModel) {
        ((TextView) findViewById(R.id.tripkoTextView)).setText(R.string.tripko_text);
        ((TextView) findViewById(R.id.sobreCoreaDescriptionText)).setText(R.string.sobre_corea_text);
        ((TextView) findViewById(R.id.sobreCoreaTitle)).setText(R.string.sobre_corea_title);
        ((TextView) findViewById(R.id.sobreCoreaText2)).setText(R.string.sobre_corea_text2);
    }

    @Override
    public void injectPresenter(Sobre_CoreaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
