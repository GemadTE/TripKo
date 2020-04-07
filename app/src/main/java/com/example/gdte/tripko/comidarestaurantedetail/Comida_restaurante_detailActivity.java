package com.example.gdte.tripko.comidarestaurantedetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Comida_restaurante_detailActivity
        extends AppCompatActivity implements Comida_restaurante_detailContract.View {

    public static String TAG = Comida_restaurante_detailActivity.class.getSimpleName();

    private Comida_restaurante_detailContract.Presenter presenter;

    private TextView comidaRestauranteTitleTextView,comidaTitle1TextView,comidaTitle2TextView;

    private RecyclerView comidaRestauranteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida_restaurante_detail);

        // do the setup
        Comida_restaurante_detailScreen.configure(this);


        comidaRestauranteTitleTextView = findViewById(R.id.comidaRestauranteTitleTextView);
        comidaTitle1TextView = findViewById(R.id.comidaTitleTextView);
        comidaTitle2TextView = findViewById(R.id.comidaTitle2TextView);

        comidaRestauranteList = findViewById(R.id.comidaRestauranteList);


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
    public void onDataUpdated(Comida_restaurante_detailViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
    }

    @Override
    public void injectPresenter(Comida_restaurante_detailContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
