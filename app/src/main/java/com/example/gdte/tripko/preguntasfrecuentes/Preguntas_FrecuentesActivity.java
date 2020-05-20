package com.example.gdte.tripko.preguntasfrecuentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;

public class Preguntas_FrecuentesActivity
        extends AppCompatActivity implements Preguntas_FrecuentesContract.View {

    public static String TAG = Preguntas_FrecuentesActivity.class.getSimpleName();

    private Preguntas_FrecuentesContract.Presenter presenter;

    private TextView tripkoTextView;


    private ImageButton homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas__frecuentes);

        tripkoTextView = findViewById(R.id.tripkoTextView);

        homeImageButton = findViewById(R.id.homeImageButton);

        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goHomeButtonClicked();
            }
        });

        if (savedInstanceState == null) AppMediator.resetInstance();

        // do the setup
        Preguntas_FrecuentesScreen.configure(this);

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
    public void onDataUpdated(Preguntas_FrecuentesViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
      //  ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, Preguntas_FrecuentesActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToHomeScreen() {
        Intent intent = new Intent(this, Menu_PrincipalActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Preguntas_FrecuentesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
