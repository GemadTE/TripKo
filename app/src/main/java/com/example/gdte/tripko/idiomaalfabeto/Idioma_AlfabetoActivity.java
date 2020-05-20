package com.example.gdte.tripko.idiomaalfabeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;

public class Idioma_AlfabetoActivity
        extends AppCompatActivity implements Idioma_AlfabetoContract.View {

    public static String TAG = Idioma_AlfabetoActivity.class.getSimpleName();

    private Idioma_AlfabetoContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma__alfabeto);

        if (savedInstanceState == null) AppMediator.resetInstance();

        // do the setup
        Idioma_AlfabetoScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(Idioma_AlfabetoViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, Idioma_AlfabetoActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Idioma_AlfabetoContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
