package com.example.gdte.tripko.tiposdesitiosturisticos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Tipos_De_Sitios_TuristicosActivity
        extends AppCompatActivity implements Tipos_De_Sitios_TuristicosContract.View {

    public static String TAG = Tipos_De_Sitios_TuristicosActivity.class.getSimpleName();

    private Tipos_De_Sitios_TuristicosContract.Presenter presenter;
    private ImageButton menuDesplegableImageButton, homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos__de__sitios__turisticos);

        // do the setup
        Tipos_De_Sitios_TuristicosScreen.configure(this);
        menuDesplegableImageButton=findViewById(R.id.menuDesplegableImageButton);
        homeImageButton=findViewById(R.id.homeImageButton);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(Tipos_De_Sitios_TuristicosViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(Tipos_De_Sitios_TuristicosContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
