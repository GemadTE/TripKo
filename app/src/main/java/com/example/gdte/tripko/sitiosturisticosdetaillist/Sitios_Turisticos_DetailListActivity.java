package com.example.gdte.tripko.sitiosturisticosdetaillist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Sitios_Turisticos_DetailListActivity
        extends AppCompatActivity implements Sitios_Turisticos_DetailListContract.View {

    public static String TAG = Sitios_Turisticos_DetailListActivity.class.getSimpleName();

    private Sitios_Turisticos_DetailListContract.Presenter presenter;
    private ImageButton preguntasFrecuentesImageButton, homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios_turisticos_detaillist);

        // do the setup
        Sitios_Turisticos_DetailListScreen.configure(this);
        preguntasFrecuentesImageButton=findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton=findViewById(R.id.homeImageButton);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(Sitios_Turisticos_DetailListViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(Sitios_Turisticos_DetailListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
