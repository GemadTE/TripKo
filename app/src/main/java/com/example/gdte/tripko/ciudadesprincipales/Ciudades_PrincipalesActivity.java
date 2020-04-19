package com.example.gdte.tripko.ciudadesprincipales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Ciudades_PrincipalesActivity
        extends AppCompatActivity implements Ciudades_PrincipalesContract.View {

    public static String TAG = Ciudades_PrincipalesActivity.class.getSimpleName();

    private Ciudades_PrincipalesContract.Presenter presenter;
    private TextView ciudadesPricipalesTitle,ciudadesPricipalesDescriptionText;
    private ImageView seul, busan, incheon, daegu, daejeon;
    private ImageButton preguntasFrecuentesImageButton, homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudades__principales);

        // do the setup
        Ciudades_PrincipalesScreen.configure(this);

        preguntasFrecuentesImageButton=findViewById(R.id.preguntasFrecuentesImageButton);
        homeImageButton=findViewById(R.id.homeImageButton);

        ciudadesPricipalesDescriptionText=findViewById(R.id.ciudadesPrincipalesDescriptionText);
        ciudadesPricipalesTitle=findViewById(R.id.ciudadesPrincipalesTitle);
        seul=findViewById(R.id.seul);
        busan=findViewById(R.id.busan);
        incheon=findViewById(R.id.incheon);
        daegu=findViewById(R.id.daegu);
        daejeon=findViewById(R.id.daejeon);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(Ciudades_PrincipalesViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(Ciudades_PrincipalesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
