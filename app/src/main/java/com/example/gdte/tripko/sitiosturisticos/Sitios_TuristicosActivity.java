package com.example.gdte.tripko.sitiosturisticos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Sitios_TuristicosActivity
        extends AppCompatActivity implements Sitios_TuristicosContract.View {

    public static String TAG = Sitios_TuristicosActivity.class.getSimpleName();

    private Sitios_TuristicosContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios__turisticos);

        // do the setup
        Sitios_TuristicosScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(Sitios_TuristicosViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(Sitios_TuristicosContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
