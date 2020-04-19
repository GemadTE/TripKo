package com.example.gdte.tripko.idioma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class IdiomaActivity
        extends AppCompatActivity implements IdiomaContract.View {

    public static String TAG = IdiomaActivity.class.getSimpleName();

    private IdiomaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_idioma);

        // do the setup
        IdiomaScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(IdiomaViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        // ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(IdiomaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
