package com.example.gdte.tripko.gastronomialist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.data.GastronomiaItem;

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

        gastronomiaListAdapter = new GastronomiaListAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GastronomiaItem item = (GastronomiaItem) v.getTag();
                presenter.selectGastronomiaListData(item);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.gastronomiaList);
        recyclerView.setAdapter(gastronomiaListAdapter);

        // do the setup
        GastronomiaListScreen.configure(this);

        presenter.fetchProductListData();
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
    public void displayProductListData(GastronomiaListViewModel viewModel) {
        gastronomiaListAdapter.setItems(viewModel.gastronomiaItems);
    }

    @Override
    public void injectPresenter(GastronomiaListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
