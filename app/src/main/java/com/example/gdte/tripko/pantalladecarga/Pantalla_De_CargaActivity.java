package com.example.gdte.tripko.pantalladecarga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Pantalla_De_CargaActivity
        extends AppCompatActivity implements Pantalla_De_CargaContract.View {

    public static String TAG = Pantalla_De_CargaActivity.class.getSimpleName();

    private Pantalla_De_CargaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__de__carga);

        // do the setup
        Pantalla_De_CargaScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(Pantalla_De_CargaViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(Pantalla_De_CargaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
