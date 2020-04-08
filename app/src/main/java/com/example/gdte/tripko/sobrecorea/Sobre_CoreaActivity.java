package com.example.gdte.tripko.sobrecorea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gdte.tripko.R;

public class Sobre_CoreaActivity
        extends AppCompatActivity implements Sobre_CoreaContract.View {

    public static String TAG = Sobre_CoreaActivity.class.getSimpleName();

    private Sobre_CoreaContract.Presenter presenter;
    private TextView sobreCoreaTitle,sobreCoreaDescriptionText;
    private ImageView image1, image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre__corea);

        // do the setup
        Sobre_CoreaScreen.configure(this);

        sobreCoreaDescriptionText=findViewById(R.id.sobreCoreaDescriptionText);
        sobreCoreaTitle=findViewById(R.id.sobreCoreaTitle);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(Sobre_CoreaViewModel viewModel) {

    }

    @Override
    public void injectPresenter(Sobre_CoreaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
