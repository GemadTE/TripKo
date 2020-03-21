package com.example.gdte.tripko.elegiridioma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Elegir_IdiomaActivity
        extends AppCompatActivity implements Elegir_IdiomaContract.View {

    public static String TAG = Elegir_IdiomaActivity.class.getSimpleName();

    private Elegir_IdiomaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_idioma);

        // do the setup
        Elegir_IdiomaScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(Elegir_IdiomaViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(Elegir_IdiomaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
