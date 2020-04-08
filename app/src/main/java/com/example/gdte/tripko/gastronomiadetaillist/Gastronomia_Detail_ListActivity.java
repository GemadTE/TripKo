package com.example.gdte.tripko.gastronomiadetaillist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Gastronomia_Detail_ListActivity
        extends AppCompatActivity implements Gastronomia_Detail_ListContract.View {

    public static String TAG = Gastronomia_Detail_ListActivity.class.getSimpleName();

    private Gastronomia_Detail_ListContract.Presenter presenter;

    private TextView comidaRestauranteTitleTextView, comidaTitle1TextView, comidaTitle2TextView;

    private ImageButton menuDesplegableImageButton, homeImageButton;

    private RecyclerView comidaRestauranteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomia_detail_list);

        // do the setup
        Gastronomia_Detail_ListScreen.configure(this);


        comidaRestauranteTitleTextView = findViewById(R.id.comidaRestauranteTitleTextView);
        comidaTitle1TextView = findViewById(R.id.comidaTitleTextView);
        comidaTitle2TextView = findViewById(R.id.comidaTitle2TextView);

        menuDesplegableImageButton = findViewById(R.id.menuDesplegableImageButton);
        homeImageButton = findViewById(R.id.homeImageButton);

        comidaRestauranteList = findViewById(R.id.comidaRestauranteList);

        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goHomeButtonClicked();
            }
        });

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
    public void onDataUpdated(Gastronomia_Detail_ListViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
    }

    @Override
    public void injectPresenter(Gastronomia_Detail_ListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
