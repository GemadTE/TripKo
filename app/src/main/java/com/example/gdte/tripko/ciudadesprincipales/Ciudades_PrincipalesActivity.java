package com.example.gdte.tripko.ciudadesprincipales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class Ciudades_PrincipalesActivity
        extends AppCompatActivity implements Ciudades_PrincipalesContract.View {

    public static String TAG = Ciudades_PrincipalesActivity.class.getSimpleName();

    private Ciudades_PrincipalesContract.Presenter presenter;
    private TextView ciudadesPricipalesTitle,ciudadesPricipalesDescriptionText;
    private ImageView seul, busan, incheon, daegu, daejeon;
    private ImageButton preguntasFrecuentesImageButton, homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudades__principales);

        // do the setup
        Ciudades_PrincipalesScreen.configure(this);

        preguntasFrecuentesImageButton=findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton=findViewById(R.id.homeImageButton);

        ciudadesPricipalesDescriptionText=findViewById(R.id.ciudadesPrincipalesDescriptionText);
        ciudadesPricipalesTitle=findViewById(R.id.ciudadesPrincipalesTitle);
        seul=findViewById(R.id.seul);
        busan=findViewById(R.id.busan);
        incheon=findViewById(R.id.incheon);
        daegu=findViewById(R.id.daegu);
        daejeon=findViewById(R.id.daejeon);


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
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(Ciudades_PrincipalesViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.ciudadesPrincipalesTitle)).setText(R.string.ciudades_principales_title);
        ((TextView) findViewById(R.id.ciudadesPrincipalesDescriptionText)).setText(R.string.ciudades_principales_text);
        ((TextView) findViewById(R.id.tripkoTextView)).setText(R.string.tripko_text);
    }

    @Override
    public void injectPresenter(Ciudades_PrincipalesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
