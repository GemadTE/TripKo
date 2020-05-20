package com.example.gdte.tripko.conversormoneda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class Conversor_MonedaActivity
        extends AppCompatActivity implements Conversor_MonedaContract.View {

    public static String TAG = Conversor_MonedaActivity.class.getSimpleName();

    private Conversor_MonedaContract.Presenter presenter;

    private TextView cantidadTextView, divisaTextView, pasarATextView,tripkoTextView;

    private EditText cantidadEditText;

    private Spinner divisaSpinner, pasarASpinner;

    private ImageButton preguntasFrecuentesImageButton,homeImageButton;

    private Button calcularButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor__moneda);

        cantidadTextView = findViewById(R.id.cantidadTextView);
        divisaTextView = findViewById(R.id.divisaTextView);
        pasarATextView = findViewById(R.id.pasarATextView);
        tripkoTextView = findViewById(R.id.tripkoTextView);

        cantidadEditText = findViewById(R.id.cantidadEditText);

        divisaSpinner = findViewById(R.id.divisaSpinner);
        pasarASpinner = findViewById(R.id.pasarASpinner);

        homeImageButton = findViewById(R.id.homeImageButton);
        preguntasFrecuentesImageButton = findViewById(R.id.preguntasFrecuentesImageButton);

        calcularButton = findViewById(R.id.calcularButton);

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

        if (savedInstanceState == null) AppMediator.resetInstance();

        // do the setup
        Conversor_MonedaScreen.configure(this);

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
    public void onDataUpdated(Conversor_MonedaViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        ((TextView) findViewById(R.id.cantidadTextView)).setText(R.string.cantidad_text_view);
        ((TextView) findViewById(R.id.divisaTextView)).setText(R.string.divisa_text);
        ((TextView) findViewById(R.id.pasarATextView)).setText(R.string.pasar_a_text);
        ((TextView) findViewById(R.id.tripkoTextView)).setText(R.string.tripko_text);
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
    public void injectPresenter(Conversor_MonedaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
