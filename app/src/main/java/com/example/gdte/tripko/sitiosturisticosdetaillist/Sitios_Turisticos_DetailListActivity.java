package com.example.gdte.tripko.sitiosturisticosdetaillist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.data.Sitios_TuristicosDetailItem;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;

public class Sitios_Turisticos_DetailListActivity
        extends AppCompatActivity implements Sitios_Turisticos_DetailListContract.View {

    public static String TAG = Sitios_Turisticos_DetailListActivity.class.getSimpleName();

    private Sitios_Turisticos_DetailListContract.Presenter presenter;
    private ImageButton preguntasFrecuentesImageButton, homeImageButton;

    private Sitios_Turisticos_DetailListAdapter sitiosTuristicosDetailListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios_turisticos_detail_list);

        preguntasFrecuentesImageButton=findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton=findViewById(R.id.homeImageButton);

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

        sitiosTuristicosDetailListAdapter = new Sitios_Turisticos_DetailListAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sitios_TuristicosDetailItem item = (Sitios_TuristicosDetailItem) v.getTag();
                presenter.selectSitioTuristicoDetailListData(item);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.sitios_turisticos_detail_list);
        recyclerView.setAdapter(sitiosTuristicosDetailListAdapter);

        // do the setup
        Sitios_Turisticos_DetailListScreen.configure(this);

      presenter.fetchSitiosTuristicosDetailListData();
    }

    @Override
    public void navigateToSitioTuristicoDetailScreen() {
        Intent intent = new Intent(this, Sitios_Turisticos_DetailListActivity.class);
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
    public void displayProductListData(final Sitios_Turisticos_DetailListViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                sitiosTuristicosDetailListAdapter.setItems(viewModel.sitios_turisticosDetailItemList);
            }
        });


     //   ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void injectPresenter(Sitios_Turisticos_DetailListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
