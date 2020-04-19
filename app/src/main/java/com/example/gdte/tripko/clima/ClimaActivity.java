package com.example.gdte.tripko.clima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class ClimaActivity
        extends AppCompatActivity implements ClimaContract.View {

    public static String TAG = ClimaActivity.class.getSimpleName();

    private ClimaContract.Presenter presenter;
    private TextView climaTitle,climaDescriptionText;
    private ImageButton preguntasFrecuentesImageButton, homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clima);

        // do the setup
        ClimaScreen.configure(this);
        preguntasFrecuentesImageButton=findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton=findViewById(R.id.homeImageButton);

        climaTitle=findViewById(R.id.climaTitle);
        climaDescriptionText=findViewById(R.id.climaDescriptionText);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(ClimaViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(ClimaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
