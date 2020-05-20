package com.example.gdte.tripko.gastronomialist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.app.AppMediator;
import com.example.gdte.tripko.data.GastronomiaItem;
import com.example.gdte.tripko.data.RegionItem;
import com.example.gdte.tripko.gastronomiadetaillist.Gastronomia_Detail_ListActivity;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class GastronomiaListActivity
        extends AppCompatActivity implements GastronomiaListContract.View {

    public static String TAG = GastronomiaListActivity.class.getSimpleName();

    private GastronomiaListContract.Presenter presenter;

    private ImageButton preguntasFrecuentesImageButton, homeImageButton;

    private GastronomiaListAdapter gastronomiaListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomia_list);

        preguntasFrecuentesImageButton = findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton = findViewById(R.id.homeImageButton);


        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goHomeButtonClicked();
            }
        });

        preguntasFrecuentesImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goPreguntasFrecuentesButtonClicked();
            }
        });

        gastronomiaListAdapter = new GastronomiaListAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GastronomiaItem item = (GastronomiaItem) v.getTag();
                presenter.selectGastronomiaListData(item);
            }
        });

        gastronomiaListAdapter = new GastronomiaListAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GastronomiaItem item = (GastronomiaItem) v.getTag();
                presenter.selectGastronomiaListData(item);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.gastronomiaList);
        recyclerView.setAdapter(gastronomiaListAdapter);

        if (savedInstanceState == null) AppMediator.resetInstance();

        // do the setup
        GastronomiaListScreen.configure(this);

        presenter.fetchProductListData();
    }


    @Override
    public void displayProductListData(final GastronomiaListViewModel viewModel) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                gastronomiaListAdapter.setItems(viewModel.gastronomiaItems);
            }
        });
    }

    @Override
    public void navigateToGastronomiaDetailListScreen() {
        Intent intent = new Intent(this, Gastronomia_Detail_ListActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToHomeScreen() {
        Intent intent = new Intent(this, Menu_PrincipalActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToPreguntasFrecuentesScreen() {
        Intent intent = new Intent(this, Preguntas_FrecuentesActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(GastronomiaListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
