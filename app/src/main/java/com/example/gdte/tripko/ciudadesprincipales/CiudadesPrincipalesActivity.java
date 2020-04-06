package com.example.gdte.tripko.ciudadesprincipales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class CiudadesPrincipalesActivity
        extends AppCompatActivity implements CiudadesPrincipalesContract.View {

    public static String TAG = CiudadesPrincipalesActivity.class.getSimpleName();

    private CiudadesPrincipalesContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudades_principales);

        // do the setup
        CiudadesPrincipalesScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(CiudadesPrincipalesViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(CiudadesPrincipalesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
