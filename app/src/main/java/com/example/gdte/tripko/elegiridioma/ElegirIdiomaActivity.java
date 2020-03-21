package com.example.gdte.tripko.elegiridioma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class ElegirIdiomaActivity
        extends AppCompatActivity implements ElegirIdiomaContract.View {

    public static String TAG = ElegirIdiomaActivity.class.getSimpleName();

    private ElegirIdiomaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_idioma);

        // do the setup
        ElegirIdiomaScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(ElegirIdiomaViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(ElegirIdiomaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
