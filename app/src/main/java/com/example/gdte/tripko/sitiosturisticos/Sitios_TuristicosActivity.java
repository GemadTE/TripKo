package com.example.gdte.tripko.sitiosturisticos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.data.Sitios_TuristicosItem;
import com.example.gdte.tripko.menuprincipal.Menu_PrincipalActivity;
import com.example.gdte.tripko.preguntasfrecuentes.Preguntas_FrecuentesActivity;
import com.example.gdte.tripko.sitiosturisticosdetaillist.Sitios_Turisticos_DetailListActivity;

public class Sitios_TuristicosActivity
        extends AppCompatActivity implements Sitios_TuristicosContract.View {

    public static String TAG = Sitios_TuristicosActivity.class.getSimpleName();

    private Sitios_TuristicosContract.Presenter presenter;

    private ImageButton preguntasFrecuentesImageButton,homeImageButton;

    private Sitios_TuristicosAdapter sitiosTuristicosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios__turisticos);

        preguntasFrecuentesImageButton = findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton = findViewById(R.id.homeImageButton);


        sitiosTuristicosAdapter = new Sitios_TuristicosAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sitios_TuristicosItem item = (Sitios_TuristicosItem) v.getTag();
                presenter.selectSitioTuristicoListData(item);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.sitios_turisticos_list);
        recyclerView.setAdapter(sitiosTuristicosAdapter);

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

        // do the setup
        Sitios_TuristicosScreen.configure(this);

        presenter.fetchSitioTuristicoListData();
    }


    @Override
    public void navigateToSitioTuristicoDetailListScreen() {
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
    public void displaySitioTuristicoListData(final Sitios_TuristicosViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((TextView) findViewById(R.id.tripkoTextView)).setText(R.string.tripko_text);
                ((TextView) findViewById(R.id.sitiosTuristicosTextView)).setText(R.string.sitios_turisticos_btn_text);

                sitiosTuristicosAdapter.setItems(viewModel.sitiosTuristicos);
            }
        });

    }

    @Override
    public void injectPresenter(Sitios_TuristicosContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
