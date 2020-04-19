package com.example.gdte.tripko.entretenimiento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.sax.EndTextElementListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.data.EntretenimientoItem;

public class EntretenimientoActivity
        extends AppCompatActivity implements EntretenimientoContract.View {

    public static String TAG = EntretenimientoActivity.class.getSimpleName();

    private EntretenimientoContract.Presenter presenter;
    private ImageButton preguntasFrecuentesImageButton, homeImageButton;

    private Button entretenimientoButton;

    private EntretenimientoAdapter entretenimientoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entretenimiento);


        preguntasFrecuentesImageButton = findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton = findViewById(R.id.homeImageButton);
        entretenimientoButton = findViewById(R.id.entretenimientoButton);


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

        entretenimientoAdapter = new EntretenimientoAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EntretenimientoItem entretenimientoItem = (EntretenimientoItem) v.getTag();
                presenter.selectEntretenimientoListData(entretenimientoItem);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.entretenimiento_list);
        recyclerView.setAdapter(entretenimientoAdapter);

        // do the setup
        EntretenimientoScreen.configure(this);

        presenter.fetchEntretenimientoListData();
    }


    @Override
    public void displayEntretenimientoListData(final EntretenimientoViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data

        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                ((TextView) findViewById(R.id.entretenimientoTextView)).setText(R.string.entretenimineto_btn_text);

                entretenimientoAdapter.setItems(viewModel.entretenimientos);
            }

        });
    }

    @Override
    public void injectPresenter(EntretenimientoContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
