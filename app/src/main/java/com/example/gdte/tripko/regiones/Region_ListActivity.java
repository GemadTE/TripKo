package com.example.gdte.tripko.regiones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.data.RegionItem;

public class Region_ListActivity
        extends AppCompatActivity implements Region_ListContract.View {

    public static String TAG = Region_ListActivity.class.getSimpleName();

    private Region_ListContract.Presenter presenter;

    private ImageButton preguntasFrecuentesImageButton,homeImageButton;

    private Region_ListAdapter regionListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_list);

        preguntasFrecuentesImageButton = findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton = findViewById(R.id.homeImageButton);



        regionListAdapter = new Region_ListAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegionItem regionItem = (RegionItem) v.getTag();
                presenter.selectRegionListData(regionItem);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.region_list);
        recyclerView.setAdapter(regionListAdapter);

        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goHomeButtonClicked();
            }
        });


        // do the setup
        Region_ListScreen.configure(this);

        //do some work
        presenter.fetchRegionListData();

    }



    @Override
    public void displayRegionListData(final Region_ListViewModel viewModel) {

        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                //deal with the data
                regionListAdapter.setItems(viewModel.regiones);
            }
        });
    }

    @Override
    public void injectPresenter(Region_ListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
